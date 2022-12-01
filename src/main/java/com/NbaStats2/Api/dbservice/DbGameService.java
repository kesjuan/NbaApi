package com.NbaStats2.Api.dbservice;


import com.NbaStats2.Api.model.Game;
import com.NbaStats2.Api.model.Team;
import com.NbaStats2.Api.repository.GameRepository;
import com.NbaStats2.Api.repository.TeamRepository;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Duration;
import java.util.List;
import java.util.Optional;

@Service
public class DbGameService {
    @Autowired
    private GameRepository gameRepository;

    @Autowired
    private TeamRepository teamRepository;

    public void clearGames(){
        gameRepository.deleteAll();
    }


    public void saveGamesForMonth(){
        FirefoxDriver driver = new FirefoxDriver();
        Duration duration = Duration.ofSeconds(260);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        driver.navigate().to("https://www.basketball-reference.com/leagues/NBA_2023_games-november.html");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"schedule\"]/tbody")));
        List<WebElement> gamesTr = driver.findElements(By.xpath("//*[@id=\"schedule\"]/tbody/tr"));
        // System.out.println(gamesTr.size());
        for (int i = 1; i < gamesTr.size(); i++) {
            try {
                String dateXpath = "//*[@id=\"schedule\"]/tbody/tr[" + i + "]/th/a";
                Game game = new Game();
                game.setDate(driver.findElement(By.xpath(dateXpath)).getText());
               // System.out.println(driver.findElement(By.xpath(dateXpath)).getText() + " is the date");
                for (int j = 1; j < 6; j++) {
                    String scheduleXpath = "//*[@id=\"schedule\"]/tbody/tr[" + i + "]/td[" + j + "]";
                    if (driver.findElement(By.xpath(scheduleXpath)).getAttribute("data-stat").contains("game_start_time")){
                            game.setStartTime(driver.findElement(By.xpath(scheduleXpath)).getText());
                    } else if (driver.findElement(By.xpath(scheduleXpath)).getAttribute("data-stat").contains("visitor_team_name")) {
                       String teamName = driver.findElement(By.xpath(scheduleXpath)).getText();
                        teamName = teamName.substring(3,9);
                       Optional<Team> team =  teamRepository.findTeamByName(teamName);
                       game.setVisitorTeam(team.get());
                    } else if ( driver.findElement(By.xpath(scheduleXpath)).getAttribute("data-stat").contains("visitor_pts")) {
                        game.setVisitorScore(driver.findElement(By.xpath(scheduleXpath)).getText());
                    } else if ( driver.findElement(By.xpath(scheduleXpath)).getAttribute("data-stat").contains("home_team_name")) {
                        String teamName =  driver.findElement(By.xpath(scheduleXpath)).getText();
                        teamName = teamName.substring(3,9);
                        Optional<Team> team = teamRepository.findTeamByName(teamName);
                        game.setHomeTeam(team.get());
                    } else if ( driver.findElement(By.xpath(scheduleXpath)).getAttribute("data-stat").contains("home_pts")) {
                        game.setHomeScore( driver.findElement(By.xpath(scheduleXpath)).getText());
                    }
                    //System.out.println(driver.findElement(By.xpath(scheduleXpath)).getText() + " " + j);
                    gameRepository.save(game);
                    //*[@id="schedule"]/tbody/tr[1]/td[1]
                    //*[@id="schedule"]/tbody/tr[1]/td[5]
                }
            }catch (NoSuchElementException e){
                e.getMessage();
            }
        }
        driver.close();
    }

}
