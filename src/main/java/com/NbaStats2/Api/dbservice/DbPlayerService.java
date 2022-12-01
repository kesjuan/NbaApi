package com.NbaStats2.Api.dbservice;

import com.NbaStats2.Api.model.Player;
import com.NbaStats2.Api.model.Team;
import com.NbaStats2.Api.repository.PlayerRepository;
import com.NbaStats2.Api.repository.StatsRepository;
import com.NbaStats2.Api.repository.TeamRepository;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class DbPlayerService {
    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private StatsRepository statsRepository;

    private Logger log = LoggerFactory.getLogger(DbPlayerService.class);

    public void savePlayer(Long playerId){
        String url = "https://balldontlie.io/api/v1/players/"+ playerId;
        RestTemplate restTemplate = new RestTemplate();
        Player player = restTemplate.getForObject(url, Player.class);
        playerRepository.save(player);
        //return new ResponseEntity<>(playerRepository.save(player), HttpStatus.OK);
    }


    public void savePlayersToTeams2(){
        FirefoxDriver driver = new FirefoxDriver();
        Duration duration = Duration.ofSeconds(240);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        try {
            driver.navigate().to("https://www.basketball-reference.com/leagues/NBA_2023_totals.html");
        }catch (TimeoutException e ){
            e.getMessage();
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"totals_stats\"]/tbody")));
        // List<WebElement>  className = driver.findElements(By.className("left"));
        List<WebElement> stuff = new ArrayList<>();
        List<WebElement> stuff1 = new ArrayList<>();
        List<WebElement> playersTr = driver.findElements(By.xpath("//*[@id=\"totals_stats\"]/tbody/tr"));
        //494
        for (int i = 1; i < playersTr.size(); i++) {
            Player player = new Player();
//*[@id="totals_stats"]/tbody/tr[489]/td[1]

            String text = "//*[@id=\"totals_stats\"]/tbody/tr[" + i + "]/td";
            stuff = driver.findElements(By.xpath(text));

            for (WebElement ayo : stuff) {
                List<WebElement> elementos = ayo.findElements(By.tagName("a"));
                for (WebElement e : elementos) {
                    if (e.getText().length() > 3) {

                        player.setName(e.getText());
                        log.info(e.getText());
                    }

                   else  {
                        Optional<Team> team = teamRepository.findTeamWithAbbreviation(e.getText());
                        if (team.isPresent()) {
                            player.setTeam(team.get());
                        }

                    }

                }

            }
            try {
                String position = driver.findElement(By.xpath("//*[@id=\"totals_stats\"]/tbody/tr["+i+"]/td[2]")).getText();
                player.setPosition(position);
            }catch (NoSuchElementException e){
                e.getMessage();
                continue;
            }

            playerRepository.save(player);
            //y += 21;
        }
driver.close();
    }
    public Player updatePlayerToTeam(String playersName){
        FirefoxDriver driver = new FirefoxDriver();
        Duration duration = Duration.ofSeconds(240);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        try {
            driver.navigate().to("https://www.basketball-reference.com/leagues/NBA_2023_totals.html");
        }catch (TimeoutException e ){
            e.getMessage();
        }
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"totals_stats\"]/tbody")));
        // List<WebElement>  className = driver.findElements(By.className("left"));
        List<WebElement> stuff = new ArrayList<>();
        List<WebElement> stuff1 = new ArrayList<>();
        List<WebElement> playersTr = driver.findElements(By.xpath("//*[@id=\"totals_stats\"]/tbody/tr"));
        //494
        Player player = new Player();
        for (int i = 1; i < playersTr.size(); i++) {

//*[@id="totals_stats"]/tbody/tr[489]/td[1]

            String text = "//*[@id=\"totals_stats\"]/tbody/tr[" + i + "]/td";
            stuff = driver.findElements(By.xpath(text));

            for (WebElement ayo : stuff) {
                List<WebElement> elementos = ayo.findElements(By.tagName("a"));
                for (WebElement e : elementos) {

                    if (e.getText().length() > 3 && playersName == e.getText()) {
                        player.setName(e.getText());
                        log.info(e.getText());
                    }

                    else  {
                        Optional<Team> team = teamRepository.findTeamWithAbbreviation(e.getText());
                        if (team.isPresent()) {
                            player.setTeam(team.get());
                        }

                    }

                }

            }
            try {
                String position = driver.findElement(By.xpath("//*[@id=\"totals_stats\"]/tbody/tr["+i+"]/td[2]")).getText();
                player.setPosition(position);
            }catch (NoSuchElementException e){
                e.getMessage();
                continue;
            }
            if (!player.getName().isEmpty()) {
                playerRepository.save(player);
            }
            //y += 21;

        }

        driver.close();
        return player;
    }








//    public void savePlayersToTeams() {
//        FirefoxDriver driver = new FirefoxDriver();
//        Duration duration = Duration.ofSeconds(120);
//        WebDriverWait wait = new WebDriverWait(driver, duration);
//        driver.navigate().to("https://www.basketball-reference.com/leagues/NBA_2023_totals.html");
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"totals_stats\"]/tbody")));
//        List<WebElement> className = driver.findElements(By.className("left"));
//        List<String> elements = new ArrayList<>();
//        for (WebElement element : className) {
//
//
//                Player player = new Player();
//                if (element.getAttribute("data-stat").contains("player")) {
//
//                    player.setName(element.getText());
//                    log.info(element.getText());
//                }
//
//                if (element.getAttribute("data-stat").contains("team_id")) {
//                    Optional<Team> team = teamRepository.findTeamWithAbbreviation(element.getText());
//                    if (team.isPresent()) {
//                        player.setTeam(team.get());
//                    }
//
//                }
//                playerRepository.save(player);
////            elements.add(element.getText());
////
////            elements.add(element.getAttribute("data-stat"));
////           System.out.println(elements);
//            }
//            driver.close();
//        }

}
