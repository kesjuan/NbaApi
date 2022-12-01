package com.NbaStats2.Api.dbservice;


import com.NbaStats2.Api.model.Player;
import com.NbaStats2.Api.model.Stats;
import com.NbaStats2.Api.repository.PlayerRepository;
import com.NbaStats2.Api.repository.StatsRepository;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
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
public class DbStatService {
    @Autowired
    private StatsRepository statsRepository;

    @Autowired
    private PlayerRepository playerRepository;

    @Autowired
    private DbPlayerService dbPlayerService;


    public void updateStatsForPlayers(){
        FirefoxDriver driver = new FirefoxDriver();

        Duration duration = Duration.ofSeconds(260);
        WebDriverWait wait = new WebDriverWait(driver, duration);
        driver.navigate().to("https://www.basketball-reference.com/leagues/NBA_2023_per_game.html");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"per_game_stats\"]/tbody")));
        List<WebElement> statsTr = driver.findElements(By.xpath("//*[@id=\"per_game_stats\"]/tbody/tr")); //495
        for (int i = 350; i < statsTr.size(); i++) {
            String nameText = " //*[@id=\"per_game_stats\"]/tbody/tr[" + i + "]/td[1]/a";
            try {
                //*[@id="per_game_stats"]/tbody/tr[466]

                String thisPlayersName = driver.findElement(By.xpath(nameText)).getText();
                //*[@id="per_game_stats"]/tbody/tr[1]/td[1]/a
                Optional<Long> playersId = playerRepository.getPlayerIdFromPlayerName(thisPlayersName);
                Optional<Player> player = playerRepository.findById(playersId.get());
                if (player.isEmpty() || playersId.isEmpty()){
                   Player player1 = dbPlayerService.updatePlayerToTeam(thisPlayersName);
                    Stats stats = new Stats();
                    player1.setStats(stats);
                    for (int j = 7; j < 30; j++) {
                        String text = "//*[@id=\"per_game_stats\"]/tbody/tr[" + i + "]/td[" + j + "]";
                        List<WebElement> statElements = driver.findElements(By.xpath(text));
                        for (WebElement ele : statElements) {
                            if (ele.getAttribute("data-stat").contains("fg_per_g")) {
                                stats.setAvgFieldGoals(ele.getText());
                                // System.out.println(ele.getText() + " index " + j);
                            } else if (ele.getAttribute("data-stat").contains("fga_per_g")) {
                                stats.setAvgFgsAttempts(ele.getText());
                            } else if (ele.getAttribute("data-stat").contains("fg_pct")) {
                                stats.setAvgFgPercent(ele.getText());
                            } else if (ele.getAttribute("data-stat").contains("fg3_per_g")) {
                                stats.setAvg3Pt(ele.getText());
                            } else if (ele.getAttribute("data-stat").contains("fg3a_per_g")) {
                                stats.setAvg3PtAttempts(ele.getText());
                            } else if (ele.getAttribute("data-stat").contains("fg3_pct")) {
                                stats.setAvg3PtPercentage(ele.getText());
                            } else if (ele.getAttribute("data-stat").contains("fg2_per_g")) {
                                stats.setAvg2Pt(ele.getText());
                            } else if (ele.getAttribute("data-stat").contains("fg2a_per_g")) {
                                stats.setAvg2PtAttempts(ele.getText());
                            } else if (ele.getAttribute("data-stat").contains("fg2_pct")) {
                                stats.setAvg2PtPercentage(ele.getText());
                            } else if (ele.getAttribute("data-stat").contains("blk_per_g")) {
                                stats.setAvgBlocks(ele.getText());
                            } else if (ele.getAttribute("data-stat").contains("ft_per_g")) {
                                stats.setAvgFreeThrows(ele.getText());
                            } else if (ele.getAttribute("data-stat").contains("fta_per_g")) {
                                stats.setAvgFtAttempts(ele.getText());
                            } else if (ele.getAttribute("data-stat").contains("ft_pct")) {
                                stats.setAvgFtPercentage(ele.getText());
                            } else if (ele.getAttribute("data-stat").contains("orb_per_g")) {
                                stats.setAvgOffensiveReb(ele.getText());
                            } else if (ele.getAttribute("data-stat").contains("drb_per_g")) {
                                stats.setAvgDefensiveReb(ele.getText());
                            } else if (ele.getAttribute("data-stat").contains("trb_per_g")) {
                                stats.setAvgTotalReb(ele.getText());
                            } else if (ele.getAttribute("data-stat").contains("ast_per_g")) {
                                stats.setAvgAssists(ele.getText());
                            } else if (ele.getAttribute("data-stat").contains("stl_per_g")) {
                                stats.setAvgSteals(ele.getText());
                            } else if (ele.getAttribute("data-stat").contains("tov_per_g")) {
                                stats.setAvgTurnovers(ele.getText());
                            } else if (ele.getAttribute("data-stat").contains("pts_per_g")) {
                                stats.setAvgPoints(ele.getText());
                            }
                        }
                        //*[@id="per_game_stats"]/tbody/tr[1]/td[29]
                        //*[@id="per_game_stats"]/tbody/tr[1]/td[7]
                    }
                }

               Stats stats = player.get().getStats();
                player.get().setStats(stats);
                for (int j = 7; j < 30; j++) {
                    String text = "//*[@id=\"per_game_stats\"]/tbody/tr[" + i + "]/td[" + j + "]";
                    List<WebElement> statElements = driver.findElements(By.xpath(text));
                    for (WebElement ele : statElements) {
                        if (ele.getAttribute("data-stat").contains("fg_per_g")) {
                            stats.setAvgFieldGoals(ele.getText());
                            // System.out.println(ele.getText() + " index " + j);
                        } else if (ele.getAttribute("data-stat").contains("fga_per_g")) {
                                    stats.setAvgFgsAttempts(ele.getText());
                        } else if (ele.getAttribute("data-stat").contains("fg_pct")) {
                                    stats.setAvgFgPercent(ele.getText());
                        } else if (ele.getAttribute("data-stat").contains("fg3_per_g")) {
                                    stats.setAvg3Pt(ele.getText());
                        } else if (ele.getAttribute("data-stat").contains("fg3a_per_g")) {
                                    stats.setAvg3PtAttempts(ele.getText());
                        } else if (ele.getAttribute("data-stat").contains("fg3_pct")) {
                                    stats.setAvg3PtPercentage(ele.getText());
                        } else if (ele.getAttribute("data-stat").contains("fg2_per_g")) {
                                    stats.setAvg2Pt(ele.getText());
                        } else if (ele.getAttribute("data-stat").contains("fg2a_per_g")) {
                                    stats.setAvg2PtAttempts(ele.getText());
                        } else if (ele.getAttribute("data-stat").contains("fg2_pct")) {
                                    stats.setAvg2PtPercentage(ele.getText());
                        } else if (ele.getAttribute("data-stat").contains("blk_per_g")) {
                                    stats.setAvgBlocks(ele.getText());
                        } else if (ele.getAttribute("data-stat").contains("ft_per_g")) {
                                    stats.setAvgFreeThrows(ele.getText());
                        } else if (ele.getAttribute("data-stat").contains("fta_per_g")) {
                                    stats.setAvgFtAttempts(ele.getText());
                        } else if (ele.getAttribute("data-stat").contains("ft_pct")) {
                                    stats.setAvgFtPercentage(ele.getText());
                        } else if (ele.getAttribute("data-stat").contains("orb_per_g")) {
                                    stats.setAvgOffensiveReb(ele.getText());
                        } else if (ele.getAttribute("data-stat").contains("drb_per_g")) {
                                    stats.setAvgDefensiveReb(ele.getText());
                        } else if (ele.getAttribute("data-stat").contains("trb_per_g")) {
                                    stats.setAvgTotalReb(ele.getText());
                        } else if (ele.getAttribute("data-stat").contains("ast_per_g")) {
                                    stats.setAvgAssists(ele.getText());
                        } else if (ele.getAttribute("data-stat").contains("stl_per_g")) {
                                    stats.setAvgSteals(ele.getText());
                        } else if (ele.getAttribute("data-stat").contains("tov_per_g")) {
                                    stats.setAvgTurnovers(ele.getText());
                        } else if (ele.getAttribute("data-stat").contains("pts_per_g")) {
                                    stats.setAvgPoints(ele.getText());
                        }
                    }
                    //*[@id="per_game_stats"]/tbody/tr[1]/td[29]
                    //*[@id="per_game_stats"]/tbody/tr[1]/td[7]
                }
                statsRepository.save(stats);
            }catch (NoSuchElementException | java.util.NoSuchElementException | TimeoutException e  ){
                e.getMessage();

            }

        }
        driver.close();
    }


}
