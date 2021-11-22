package samin005.rummikub.selenium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import samin005.rummikub.model.Game;
import samin005.rummikub.model.Player;
import samin005.rummikub.service.GameService;

import java.util.concurrent.TimeUnit;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class SeleniumTestSuite {

    @Autowired
    private GameService gameService;
    private final WebDriverLibrary webDriverLibrary = new WebDriverLibrary();
    private final long implicitWaitDriver = 2000;
    private final int waitPerAction = 2000;
    private final int waitAfterCompletion = 10000;

    @Test
    public void row11() {
        gameService.resetGame();
        WebDriver player1ChromeDriver = webDriverLibrary.getChromeDriver();
        player1ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player1ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        Game currentGame = gameService.getCurrentGame();
        Player player1 = currentGame.getPlayerByNumber(1);

        gameService.placeInHand(player1, "R1 R2 R3 R4 R5 R6 R7 R8 R10 R11 R12 B9 G9 O9");

        WebDriver player2ChromeDriver = webDriverLibrary.getChromeDriver();
        player2ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player2ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnJoinGame")).click();

        WebDriver player3EdgeDriver = webDriverLibrary.getEdgeDriver();
        player3EdgeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player3EdgeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player3EdgeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-11")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-12")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-13")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();

        wait(waitAfterCompletion);
        // invalid
        Assertions.assertEquals(0, currentGame.getBoard().size());

        player1ChromeDriver.close();
        player2ChromeDriver.close();
        player3EdgeDriver.close();
    }

    @Test
    public void row17() {
        gameService.resetGame();
        WebDriver player1ChromeDriver = webDriverLibrary.getChromeDriver();
        player1ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player1ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        Game currentGame = gameService.getCurrentGame();
        Player player1 = currentGame.getPlayerByNumber(1);

        gameService.placeInHand(player1, "R1 R2 R3 R4 R5 R6 R7 R8 R10 R11 R12 B11 G11 O11");

        WebDriver player2ChromeDriver = webDriverLibrary.getChromeDriver();
        player2ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player2ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnJoinGame")).click();

        WebDriver player3EdgeDriver = webDriverLibrary.getEdgeDriver();
        player3EdgeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player3EdgeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player3EdgeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-11")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-12")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-13")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();

        wait(waitAfterCompletion);
        // valid
        Assertions.assertTrue(currentGame.getBoard().size() > 0);

        player1ChromeDriver.close();
        player2ChromeDriver.close();
        player3EdgeDriver.close();
    }

    @Test
    public void row23() {
        gameService.resetGame();
        WebDriver player1ChromeDriver = webDriverLibrary.getChromeDriver();
        player1ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player1ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        Game currentGame = gameService.getCurrentGame();
        Player player1 = currentGame.getPlayerByNumber(1);

        gameService.placeInHand(player1, "R1 R2 R3 R4 R5 R6 R7 R8 R9 R10 R11 B9 G9 O9");

        WebDriver player2ChromeDriver = webDriverLibrary.getChromeDriver();
        player2ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player2ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnJoinGame")).click();

        WebDriver player3EdgeDriver = webDriverLibrary.getEdgeDriver();
        player3EdgeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player3EdgeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player3EdgeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-8")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-11")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-12")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-13")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();

        wait(waitAfterCompletion);
        // valid
        Assertions.assertTrue(currentGame.getBoard().size() > 0);

        player1ChromeDriver.close();
        player2ChromeDriver.close();
        player3EdgeDriver.close();
    }

    @Test
    public void row29() {
        gameService.resetGame();
        WebDriver player1ChromeDriver = webDriverLibrary.getChromeDriver();
        player1ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player1ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        Game currentGame = gameService.getCurrentGame();
        Player player1 = currentGame.getPlayerByNumber(1);

        gameService.placeInHand(player1, "R1 R2 R3 R4 R5 R6 R7 R9 R10 R11 B8 B9 G9 O9");

        WebDriver player2ChromeDriver = webDriverLibrary.getChromeDriver();
        player2ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player2ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnJoinGame")).click();

        WebDriver player3EdgeDriver = webDriverLibrary.getEdgeDriver();
        player3EdgeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player3EdgeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player3EdgeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-7")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-8")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-9")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();

        wait(waitAfterCompletion);
        // invalid
        Assertions.assertEquals(0, currentGame.getBoard().size());

        player1ChromeDriver.close();
        player2ChromeDriver.close();
        player3EdgeDriver.close();
    }

    @Test
    public void row35() {
        gameService.resetGame();
        WebDriver player1ChromeDriver = webDriverLibrary.getChromeDriver();
        player1ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player1ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        Game currentGame = gameService.getCurrentGame();
        Player player1 = currentGame.getPlayerByNumber(1);

        gameService.placeInHand(player1, "R1 R2 R3 R4 R5 R6 R7 R8 R9 R11 R12 R13 B2 O9");

        WebDriver player2ChromeDriver = webDriverLibrary.getChromeDriver();
        player2ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player2ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnJoinGame")).click();

        WebDriver player3EdgeDriver = webDriverLibrary.getEdgeDriver();
        player3EdgeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player3EdgeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player3EdgeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-9")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-10")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-11")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();

        wait(waitAfterCompletion);
        // valid
        Assertions.assertTrue(currentGame.getBoard().size() > 0);

        player1ChromeDriver.close();
        player2ChromeDriver.close();
        player3EdgeDriver.close();
    }

    @Test
    public void row41() {
        gameService.resetGame();
        WebDriver player1ChromeDriver = webDriverLibrary.getChromeDriver();
        player1ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player1ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        Game currentGame = gameService.getCurrentGame();
        Player player1 = currentGame.getPlayerByNumber(1);

        gameService.placeInHand(player1, "R1 R2 R4 R5 R7 R8 R10 R11 B9 G8 G9 G10 G11 O9");

        WebDriver player2ChromeDriver = webDriverLibrary.getChromeDriver();
        player2ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player2ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnJoinGame")).click();

        WebDriver player3EdgeDriver = webDriverLibrary.getEdgeDriver();
        player3EdgeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player3EdgeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player3EdgeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-9")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-10")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-11")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-12")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();

        wait(waitAfterCompletion);
        // valid
        Assertions.assertTrue(currentGame.getBoard().size() > 0);

        player1ChromeDriver.close();
        player2ChromeDriver.close();
        player3EdgeDriver.close();
    }

    @Test
    public void row47() {
        gameService.resetGame();
        WebDriver player1ChromeDriver = webDriverLibrary.getChromeDriver();
        player1ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player1ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        Game currentGame = gameService.getCurrentGame();
        Player player1 = currentGame.getPlayerByNumber(1);

        gameService.placeInHand(player1, "R1 R2 R3 R3 R4 R5 B1 B3 B9 G1 G2 G3 O1 O3");

        WebDriver player2ChromeDriver = webDriverLibrary.getChromeDriver();
        player2ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player2ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnJoinGame")).click();

        WebDriver player3EdgeDriver = webDriverLibrary.getEdgeDriver();
        player3EdgeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player3EdgeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player3EdgeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-0")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-12")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-6")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);

        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-0")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-1")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-3")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);

        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-0")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-7")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-2")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);

        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-2")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-3")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-4")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();

        wait(waitAfterCompletion);
        // invalid
        Assertions.assertEquals(0, currentGame.getBoard().size());

        player1ChromeDriver.close();
        player2ChromeDriver.close();
        player3EdgeDriver.close();
    }

    @Test
    public void row53() {
        gameService.resetGame();
        WebDriver player1ChromeDriver = webDriverLibrary.getChromeDriver();
        player1ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player1ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        Game currentGame = gameService.getCurrentGame();
        Player player1 = currentGame.getPlayerByNumber(1);

        gameService.placeInHand(player1, "R1 R2 R3 R3 R4 R5 B1 B3 B9 G2 G3 G4 O1 O3");

        WebDriver player2ChromeDriver = webDriverLibrary.getChromeDriver();
        player2ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player2ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnJoinGame")).click();

        WebDriver player3EdgeDriver = webDriverLibrary.getEdgeDriver();
        player3EdgeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player3EdgeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player3EdgeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-0")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-12")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-6")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);

        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-0")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-1")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-3")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);

        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-0")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-7")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-2")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);

        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-2")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-3")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-4")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();

        wait(waitAfterCompletion);
        // valid
        Assertions.assertTrue(currentGame.getBoard().size() > 0);

        player1ChromeDriver.close();
        player2ChromeDriver.close();
        player3EdgeDriver.close();
    }

    @Test
    public void row59() {
        gameService.resetGame();
        WebDriver player1ChromeDriver = webDriverLibrary.getChromeDriver();
        player1ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player1ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        Game currentGame = gameService.getCurrentGame();
        Player player1 = currentGame.getPlayerByNumber(1);

        gameService.placeInHand(player1, "R2 R3 R3 R4 R5 R11 B3 B9 B11 G2 G3 G4 O3 O11");

        WebDriver player2ChromeDriver = webDriverLibrary.getChromeDriver();
        player2ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player2ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnJoinGame")).click();

        WebDriver player3EdgeDriver = webDriverLibrary.getEdgeDriver();
        player3EdgeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player3EdgeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player3EdgeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-5")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-13")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-8")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);

        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-0")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-1")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-3")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);

        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-0")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-7")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-2")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);

        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-2")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-3")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-4")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();

        wait(waitAfterCompletion);
        // valid
        Assertions.assertTrue(currentGame.getBoard().size() > 0);

        player1ChromeDriver.close();
        player2ChromeDriver.close();
        player3EdgeDriver.close();
    }

    @Test
    public void row66() {
        gameService.resetGame();
        WebDriver player1ChromeDriver = webDriverLibrary.getChromeDriver();
        player1ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player1ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        Game currentGame = gameService.getCurrentGame();
        Player player1 = currentGame.getPlayerByNumber(1);

        gameService.placeInHand(player1, "R1 R2 R3 R4 R5 R6 R7 R8 R10 R11 R12 B9 G9 *");

        WebDriver player2ChromeDriver = webDriverLibrary.getChromeDriver();
        player2ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player2ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnJoinGame")).click();

        WebDriver player3EdgeDriver = webDriverLibrary.getEdgeDriver();
        player3EdgeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player3EdgeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player3EdgeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-11")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-12")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-13")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();

        wait(waitAfterCompletion);
        // invalid
        Assertions.assertEquals(0, currentGame.getBoard().size());

        player1ChromeDriver.close();
        player2ChromeDriver.close();
        player3EdgeDriver.close();
    }

    @Test
    public void row72() {
        gameService.resetGame();
        WebDriver player1ChromeDriver = webDriverLibrary.getChromeDriver();
        player1ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player1ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        Game currentGame = gameService.getCurrentGame();
        Player player1 = currentGame.getPlayerByNumber(1);

        gameService.placeInHand(player1, "R1 R2 R3 R4 R5 R6 R7 R8 R10 R11 R12 B11 G11 *");

        WebDriver player2ChromeDriver = webDriverLibrary.getChromeDriver();
        player2ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player2ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnJoinGame")).click();

        WebDriver player3EdgeDriver = webDriverLibrary.getEdgeDriver();
        player3EdgeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player3EdgeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player3EdgeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-11")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-12")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-13")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();

        wait(waitAfterCompletion);
        // valid
        Assertions.assertTrue(currentGame.getBoard().size() > 0);

        player1ChromeDriver.close();
        player2ChromeDriver.close();
        player3EdgeDriver.close();
    }

    @Test
    public void row78() {
        gameService.resetGame();
        WebDriver player1ChromeDriver = webDriverLibrary.getChromeDriver();
        player1ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player1ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        Game currentGame = gameService.getCurrentGame();
        Player player1 = currentGame.getPlayerByNumber(1);

        gameService.placeInHand(player1, "R1 R2 R3 R4 R5 R6 R7 R8 R9 R10 R11 B9 G9 *");

        WebDriver player2ChromeDriver = webDriverLibrary.getChromeDriver();
        player2ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player2ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnJoinGame")).click();

        WebDriver player3EdgeDriver = webDriverLibrary.getEdgeDriver();
        player3EdgeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player3EdgeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player3EdgeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-8")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-11")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-12")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-13")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();

        wait(waitAfterCompletion);
        // valid
        Assertions.assertTrue(currentGame.getBoard().size() > 0);

        player1ChromeDriver.close();
        player2ChromeDriver.close();
        player3EdgeDriver.close();
    }

    @Test
    public void row84() {
        gameService.resetGame();
        WebDriver player1ChromeDriver = webDriverLibrary.getChromeDriver();
        player1ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player1ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        Game currentGame = gameService.getCurrentGame();
        Player player1 = currentGame.getPlayerByNumber(1);

        gameService.placeInHand(player1, "R1 R2 R3 R4 R5 R6 R7 R10 R11 B8 B9 G9 O9 *");

        WebDriver player2ChromeDriver = webDriverLibrary.getChromeDriver();
        player2ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player2ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnJoinGame")).click();

        WebDriver player3EdgeDriver = webDriverLibrary.getEdgeDriver();
        player3EdgeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player3EdgeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player3EdgeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-13")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-7")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-8")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();

        wait(waitAfterCompletion);
        // invalid
        Assertions.assertEquals(0, currentGame.getBoard().size());

        player1ChromeDriver.close();
        player2ChromeDriver.close();
        player3EdgeDriver.close();
    }

    @Test
    public void row90() {
        gameService.resetGame();
        WebDriver player1ChromeDriver = webDriverLibrary.getChromeDriver();
        player1ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player1ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        Game currentGame = gameService.getCurrentGame();
        Player player1 = currentGame.getPlayerByNumber(1);

        gameService.placeInHand(player1, "R1 R2 R3 R4 R5 R6 R7 R8 R9 R11 R13 B2 O9 *");

        WebDriver player2ChromeDriver = webDriverLibrary.getChromeDriver();
        player2ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player2ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnJoinGame")).click();

        WebDriver player3EdgeDriver = webDriverLibrary.getEdgeDriver();
        player3EdgeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player3EdgeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player3EdgeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-9")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-13")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-10")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();

        wait(waitAfterCompletion);
        // valid
        Assertions.assertTrue(currentGame.getBoard().size() > 0);

        player1ChromeDriver.close();
        player2ChromeDriver.close();
        player3EdgeDriver.close();
    }

    @Test
    public void row96() {
        gameService.resetGame();
        WebDriver player1ChromeDriver = webDriverLibrary.getChromeDriver();
        player1ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player1ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        Game currentGame = gameService.getCurrentGame();
        Player player1 = currentGame.getPlayerByNumber(1);

        gameService.placeInHand(player1, "R1 R2 R4 R5 R7 R8 R10 R11 B9 G8 G9 G10 O9 *");

        WebDriver player2ChromeDriver = webDriverLibrary.getChromeDriver();
        player2ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player2ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnJoinGame")).click();

        WebDriver player3EdgeDriver = webDriverLibrary.getEdgeDriver();
        player3EdgeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player3EdgeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player3EdgeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-9")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-10")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-11")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-13")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();

        wait(waitAfterCompletion);
        // valid
        Assertions.assertTrue(currentGame.getBoard().size() > 0);

        player1ChromeDriver.close();
        player2ChromeDriver.close();
        player3EdgeDriver.close();
    }

    @Test
    public void row102() {
        gameService.resetGame();
        WebDriver player1ChromeDriver = webDriverLibrary.getChromeDriver();
        player1ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player1ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        Game currentGame = gameService.getCurrentGame();
        Player player1 = currentGame.getPlayerByNumber(1);

        gameService.placeInHand(player1, "R1 R2 R3 R3 R4 R5 B1 B3 B9 G2 G3 G4 O1 *");

        WebDriver player2ChromeDriver = webDriverLibrary.getChromeDriver();
        player2ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player2ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnJoinGame")).click();

        WebDriver player3EdgeDriver = webDriverLibrary.getEdgeDriver();
        player3EdgeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player3EdgeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player3EdgeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-0")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-12")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-6")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);

        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-0")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-1")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-3")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);

        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-0")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-7")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-2")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);

        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-2")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-3")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-4")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();

        wait(waitAfterCompletion);
        // valid
        Assertions.assertTrue(currentGame.getBoard().size() > 0);

        player1ChromeDriver.close();
        player2ChromeDriver.close();
        player3EdgeDriver.close();
    }

    @Test
    public void row108() {
        gameService.resetGame();
        WebDriver player1ChromeDriver = webDriverLibrary.getChromeDriver();
        player1ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player1ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        Game currentGame = gameService.getCurrentGame();
        Player player1 = currentGame.getPlayerByNumber(1);

        gameService.placeInHand(player1, "R2 R3 R3 R4 R5 R11 B3 B9 B11 G2 G3 G4 * *");

        WebDriver player2ChromeDriver = webDriverLibrary.getChromeDriver();
        player2ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player2ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnJoinGame")).click();

        WebDriver player3EdgeDriver = webDriverLibrary.getEdgeDriver();
        player3EdgeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player3EdgeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player3EdgeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-5")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-13")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-8")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);

        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-0")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-1")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-3")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);

        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-0")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-7")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-2")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);

        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-2")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-3")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-4")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();

        wait(waitAfterCompletion);
        // valid
        Assertions.assertTrue(currentGame.getBoard().size() > 0);

        player1ChromeDriver.close();
        player2ChromeDriver.close();
        player3EdgeDriver.close();
    }

    @Test
    public void row115() {
        gameService.resetGame();
        WebDriver player1ChromeDriver = webDriverLibrary.getChromeDriver();
        player1ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player1ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        Game currentGame = gameService.getCurrentGame();
        Player player1 = currentGame.getPlayerByNumber(1);

        gameService.placeInHand(player1, "R1 R2 R4 R5 R7 R8 R10 R11 R13 B3 B6 G9 O9 O12");

        WebDriver player2ChromeDriver = webDriverLibrary.getChromeDriver();
        player2ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player2ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnJoinGame")).click();

        WebDriver player3EdgeDriver = webDriverLibrary.getEdgeDriver();
        player3EdgeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player3EdgeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player3EdgeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        player1ChromeDriver.findElement(By.id("btnDraw")).click();

        wait(waitAfterCompletion);
        // valid
        Assertions.assertEquals(0, currentGame.getBoard().size());
        Assertions.assertEquals(15, player1.getInHand().size());

        player1ChromeDriver.close();
        player2ChromeDriver.close();
        player3EdgeDriver.close();
    }

    @Test
    public void row121() {
        gameService.resetGame();
        WebDriver player1ChromeDriver = webDriverLibrary.getChromeDriver();
        player1ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player1ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        Game currentGame = gameService.getCurrentGame();
        Player player1 = currentGame.getPlayerByNumber(1);

        gameService.placeInHand(player1, "R1 R2 R4 R5 R7 R8 R10 R11 R12 B3 B6 G9 O9 O12");

        WebDriver player2ChromeDriver = webDriverLibrary.getChromeDriver();
        player2ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player2ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnJoinGame")).click();

        WebDriver player3EdgeDriver = webDriverLibrary.getEdgeDriver();
        player3EdgeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player3EdgeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player3EdgeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-6")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-7")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-8")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();
        wait(waitPerAction);

        player2ChromeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);

        player3EdgeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);

        player1ChromeDriver.findElement(By.id("btnDraw")).click();

        wait(waitAfterCompletion);
        // valid
        Assertions.assertTrue(currentGame.getBoard().size() > 0);
        Assertions.assertEquals(12, player1.getInHand().size());

        player1ChromeDriver.close();
        player2ChromeDriver.close();
        player3EdgeDriver.close();
    }

    @Test
    public void row127() {
        gameService.resetGame();
        WebDriver player1ChromeDriver = webDriverLibrary.getChromeDriver();
        player1ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player1ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        Game currentGame = gameService.getCurrentGame();
        Player player1 = currentGame.getPlayerByNumber(1);

        gameService.placeInHand(player1, "R1 R2 R4 R5 R7 R8 R10 R11 R12 B3 B6 G9 O9 O12");

        WebDriver player2ChromeDriver = webDriverLibrary.getChromeDriver();
        player2ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player2ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnJoinGame")).click();

        WebDriver player3EdgeDriver = webDriverLibrary.getEdgeDriver();
        player3EdgeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player3EdgeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player3EdgeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        player1ChromeDriver.findElement(By.id("btnDraw")).click();

        wait(waitAfterCompletion);
        // valid
        Assertions.assertEquals(0, currentGame.getBoard().size());
        Assertions.assertEquals(15, player1.getInHand().size());

        player1ChromeDriver.close();
        player2ChromeDriver.close();
        player3EdgeDriver.close();
    }

    @Test
    public void row133() {
        gameService.resetGame();
        WebDriver player1ChromeDriver = webDriverLibrary.getChromeDriver();
        player1ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player1ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        Game currentGame = gameService.getCurrentGame();
        Player player1 = currentGame.getPlayerByNumber(1);

        gameService.placeInHand(player1, "R1 R2 R3 R5 R7 R8 R10 R11 R12 B3 B6 G9 O9 O12");

        WebDriver player2ChromeDriver = webDriverLibrary.getChromeDriver();
        player2ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player2ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnJoinGame")).click();

        WebDriver player3EdgeDriver = webDriverLibrary.getEdgeDriver();
        player3EdgeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player3EdgeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player3EdgeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-6")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-7")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-8")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();
        wait(waitPerAction);

        player2ChromeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);

        player3EdgeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);

        player1ChromeDriver.findElement(By.id("btnDraw")).click();

        wait(waitAfterCompletion);
        // valid
        Assertions.assertTrue(currentGame.getBoard().size() > 0);
        Assertions.assertEquals(12, player1.getInHand().size());

        player1ChromeDriver.close();
        player2ChromeDriver.close();
        player3EdgeDriver.close();
    }

    @Test
    public void row139() {
        gameService.resetGame();
        WebDriver player1ChromeDriver = webDriverLibrary.getChromeDriver();
        player1ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player1ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        Game currentGame = gameService.getCurrentGame();
        Player player1 = currentGame.getPlayerByNumber(1);

        gameService.placeInHand(player1, "R1 R2 R4 R5 R7 R9 R10 R11 R12 B3 B6 G9 O9 O12");

        WebDriver player2ChromeDriver = webDriverLibrary.getChromeDriver();
        player2ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player2ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnJoinGame")).click();

        WebDriver player3EdgeDriver = webDriverLibrary.getEdgeDriver();
        player3EdgeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player3EdgeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player3EdgeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-6")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-7")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-8")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();
        wait(waitPerAction);

        player2ChromeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);

        player3EdgeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);

        player1ChromeDriver.findElement(By.id("btnDraw")).click();

        wait(waitAfterCompletion);
        // valid
        Assertions.assertTrue(currentGame.getBoard().size() > 0);
        Assertions.assertEquals(12, player1.getInHand().size());

        player1ChromeDriver.close();
        player2ChromeDriver.close();
        player3EdgeDriver.close();
    }

    @Test
    public void row146() {
        gameService.resetGame();
        WebDriver player1ChromeDriver = webDriverLibrary.getChromeDriver();
        player1ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player1ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        Game currentGame = gameService.getCurrentGame();
        Player player1 = currentGame.getPlayerByNumber(1);

        gameService.placeInHand(player1, "R10 R11 R12 B1 B4 B11 B12 B13 G1 G4 G11 O1 O4 O11");

        WebDriver player2ChromeDriver = webDriverLibrary.getChromeDriver();
        player2ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player2ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnJoinGame")).click();

        WebDriver player3EdgeDriver = webDriverLibrary.getEdgeDriver();
        player3EdgeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player3EdgeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player3EdgeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-0")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-1")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-2")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();
        wait(waitPerAction);

        player2ChromeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);

        player3EdgeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);


        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-2")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-7")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-10")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();

        wait(waitAfterCompletion);
        // valid
        Assertions.assertTrue(currentGame.getBoard().size() > 1);

        player1ChromeDriver.close();
        player2ChromeDriver.close();
        player3EdgeDriver.close();
    }

    @Test
    public void row152() {
        gameService.resetGame();
        WebDriver player1ChromeDriver = webDriverLibrary.getChromeDriver();
        player1ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player1ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        Game currentGame = gameService.getCurrentGame();
        Player player1 = currentGame.getPlayerByNumber(1);

        gameService.placeInHand(player1, "R10 R11 R12 B1 B4 B11 B12 B13 G1 G4 G11 O1 O4 O11");

        WebDriver player2ChromeDriver = webDriverLibrary.getChromeDriver();
        player2ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player2ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnJoinGame")).click();

        WebDriver player3EdgeDriver = webDriverLibrary.getEdgeDriver();
        player3EdgeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player3EdgeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player3EdgeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-0")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-1")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-2")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();
        wait(waitPerAction);

        player2ChromeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);

        player3EdgeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);


        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-2")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-3")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-4")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();

        wait(waitAfterCompletion);
        // valid
        Assertions.assertTrue(currentGame.getBoard().size() > 1);

        player1ChromeDriver.close();
        player2ChromeDriver.close();
        player3EdgeDriver.close();
    }

    @Test
    public void row158() {
        gameService.resetGame();
        WebDriver player1ChromeDriver = webDriverLibrary.getChromeDriver();
        player1ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player1ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        Game currentGame = gameService.getCurrentGame();
        Player player1 = currentGame.getPlayerByNumber(1);

        gameService.placeInHand(player1, "R10 R11 R12 B1 B4 B11 B12 B13 G1 G4 G11 O1 O4 O11");

        WebDriver player2ChromeDriver = webDriverLibrary.getChromeDriver();
        player2ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player2ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnJoinGame")).click();

        WebDriver player3EdgeDriver = webDriverLibrary.getEdgeDriver();
        player3EdgeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player3EdgeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player3EdgeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-0")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-1")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-2")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();
        wait(waitPerAction);

        player2ChromeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);

        player3EdgeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);


        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-2")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-3")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-4")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);

        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-0")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-2")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-5")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);

        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-0")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-1")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-3")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();

        wait(waitAfterCompletion);
        // valid
        Assertions.assertTrue(currentGame.getBoard().size() > 1);

        player1ChromeDriver.close();
        player2ChromeDriver.close();
        player3EdgeDriver.close();
    }

    @Test
    public void row165() {
        gameService.resetGame();
        WebDriver player1ChromeDriver = webDriverLibrary.getChromeDriver();
        player1ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player1ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        Game currentGame = gameService.getCurrentGame();
        Player player1 = currentGame.getPlayerByNumber(1);

        gameService.placeInHand(player1, "R10 R11 R12 B1 B4 B11 B12 B13 G1 G4 G11 O1 O4 O11");

        WebDriver player2ChromeDriver = webDriverLibrary.getChromeDriver();
        player2ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player2ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnJoinGame")).click();

        WebDriver player3EdgeDriver = webDriverLibrary.getEdgeDriver();
        player3EdgeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player3EdgeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player3EdgeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-0")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-1")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-2")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();
        wait(waitPerAction);

        player2ChromeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);

        player3EdgeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);


        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-2")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-3")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();

        wait(waitAfterCompletion);
        // invalid
        Assertions.assertEquals(1, currentGame.getBoard().size());

        player1ChromeDriver.close();
        player2ChromeDriver.close();
        player3EdgeDriver.close();
    }

    @Test
    public void row171() {
        gameService.resetGame();
        WebDriver player1ChromeDriver = webDriverLibrary.getChromeDriver();
        player1ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player1ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        Game currentGame = gameService.getCurrentGame();
        Player player1 = currentGame.getPlayerByNumber(1);

        gameService.placeInHand(player1, "R10 R11 R12 B1 B4 B11 B12 B13 G1 G4 G11 O1 O4 O11");

        WebDriver player2ChromeDriver = webDriverLibrary.getChromeDriver();
        player2ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player2ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnJoinGame")).click();

        WebDriver player3EdgeDriver = webDriverLibrary.getEdgeDriver();
        player3EdgeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player3EdgeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player3EdgeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-0")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-1")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-2")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();
        wait(waitPerAction);

        player2ChromeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);

        player3EdgeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);


        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-2")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-7")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();

        wait(waitAfterCompletion);
        // invalid
        Assertions.assertEquals(1, currentGame.getBoard().size());

        player1ChromeDriver.close();
        player2ChromeDriver.close();
        player3EdgeDriver.close();
    }

    @Test
    public void row177() {
        gameService.resetGame();
        WebDriver player1ChromeDriver = webDriverLibrary.getChromeDriver();
        player1ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player1ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        Game currentGame = gameService.getCurrentGame();
        Player player1 = currentGame.getPlayerByNumber(1);

        gameService.placeInHand(player1, "R10 R11 R12 B1 B11 B11 B12 B13 G1 G4 G11 O1 O4 O11");

        WebDriver player2ChromeDriver = webDriverLibrary.getChromeDriver();
        player2ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player2ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnJoinGame")).click();

        WebDriver player3EdgeDriver = webDriverLibrary.getEdgeDriver();
        player3EdgeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player3EdgeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player3EdgeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-0")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-1")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-2")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();
        wait(waitPerAction);

        player2ChromeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);

        player3EdgeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);


        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-1")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-2")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-7")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();

        wait(waitAfterCompletion);
        // invalid
        Assertions.assertEquals(1, currentGame.getBoard().size());

        player1ChromeDriver.close();
        player2ChromeDriver.close();
        player3EdgeDriver.close();
    }

    @Test
    public void row183() {
        gameService.resetGame();
        WebDriver player1ChromeDriver = webDriverLibrary.getChromeDriver();
        player1ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player1ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        Game currentGame = gameService.getCurrentGame();
        Player player1 = currentGame.getPlayerByNumber(1);

        gameService.placeInHand(player1, "R10 R11 R12 B1 B11 B11 B12 B13 G1 G4 G11 O1 O4 O11");

        WebDriver player2ChromeDriver = webDriverLibrary.getChromeDriver();
        player2ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player2ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnJoinGame")).click();

        WebDriver player3EdgeDriver = webDriverLibrary.getEdgeDriver();
        player3EdgeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player3EdgeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player3EdgeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-0")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-1")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-2")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();
        wait(waitPerAction);

        player2ChromeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);

        player3EdgeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);


        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-1")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-2")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-3")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-4")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();

        wait(waitAfterCompletion);
        // invalid
        Assertions.assertEquals(1, currentGame.getBoard().size());

        player1ChromeDriver.close();
        player2ChromeDriver.close();
        player3EdgeDriver.close();
    }

    @Test
    public void row189() {
        gameService.resetGame();
        WebDriver player1ChromeDriver = webDriverLibrary.getChromeDriver();
        player1ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player1ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        Game currentGame = gameService.getCurrentGame();
        Player player1 = currentGame.getPlayerByNumber(1);

        gameService.placeInHand(player1, "R10 R11 R12 B1 B11 B11 B12 B13 G1 G4 G11 O1 O4 O11");

        WebDriver player2ChromeDriver = webDriverLibrary.getChromeDriver();
        player2ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player2ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnJoinGame")).click();

        WebDriver player3EdgeDriver = webDriverLibrary.getEdgeDriver();
        player3EdgeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player3EdgeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player3EdgeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-0")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-1")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-2")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();
        wait(waitPerAction);

        player2ChromeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);

        player3EdgeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);


        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-7")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-3")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-4")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();

        wait(waitAfterCompletion);
        // invalid
        Assertions.assertEquals(1, currentGame.getBoard().size());

        player1ChromeDriver.close();
        player2ChromeDriver.close();
        player3EdgeDriver.close();
    }

    @Test
    public void row195() {
        gameService.resetGame();
        WebDriver player1ChromeDriver = webDriverLibrary.getChromeDriver();
        player1ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player1ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        Game currentGame = gameService.getCurrentGame();
        Player player1 = currentGame.getPlayerByNumber(1);

        gameService.placeInHand(player1, "R10 R11 R12 B1 B11 B11 B12 B13 G1 G4 G11 O1 O4 O11");

        WebDriver player2ChromeDriver = webDriverLibrary.getChromeDriver();
        player2ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player2ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnJoinGame")).click();

        WebDriver player3EdgeDriver = webDriverLibrary.getEdgeDriver();
        player3EdgeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player3EdgeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player3EdgeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-0")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-1")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-2")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();
        wait(waitPerAction);

        player2ChromeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);

        player3EdgeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);


        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-3")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-2")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-4")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();

        wait(waitAfterCompletion);
        // invalid
        Assertions.assertEquals(1, currentGame.getBoard().size());

        player1ChromeDriver.close();
        player2ChromeDriver.close();
        player3EdgeDriver.close();
    }

    @Test
    public void row201() {
        gameService.resetGame();
        WebDriver player1ChromeDriver = webDriverLibrary.getChromeDriver();
        player1ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player1ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        Game currentGame = gameService.getCurrentGame();
        Player player1 = currentGame.getPlayerByNumber(1);

        gameService.placeInHand(player1, "R10 R11 R12 B1 B11 B11 B12 B13 G1 G4 G11 O1 O4 O11");

        WebDriver player2ChromeDriver = webDriverLibrary.getChromeDriver();
        player2ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player2ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnJoinGame")).click();

        WebDriver player3EdgeDriver = webDriverLibrary.getEdgeDriver();
        player3EdgeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player3EdgeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player3EdgeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-0")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-1")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-2")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();
        wait(waitPerAction);

        player2ChromeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);

        player3EdgeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);


        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-2")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-3")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-7")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();

        wait(waitAfterCompletion);
        // invalid
        Assertions.assertEquals(1, currentGame.getBoard().size());

        player1ChromeDriver.close();
        player2ChromeDriver.close();
        player3EdgeDriver.close();
    }

    @Test
    public void row208() {
        gameService.resetGame();
        WebDriver player1ChromeDriver = webDriverLibrary.getChromeDriver();
        player1ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player1ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        Game currentGame = gameService.getCurrentGame();
        Player player1 = currentGame.getPlayerByNumber(1);

        gameService.placeInHand(player1, "R7 R8 R9 R10 R10 R11 R12 B1 B11 B11 B12 B13 G1 G4");

        WebDriver player2ChromeDriver = webDriverLibrary.getChromeDriver();
        player2ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player2ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnJoinGame")).click();

        WebDriver player3EdgeDriver = webDriverLibrary.getEdgeDriver();
        player3EdgeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player3EdgeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player3EdgeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-4")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-5")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-6")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();
        wait(waitPerAction);

        player2ChromeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);

        player3EdgeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);


        player1ChromeDriver.findElement(By.id("btnAdd")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-0")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-1")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("meld0-tile0")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();

        wait(waitAfterCompletion);
        // invalid
        Assertions.assertEquals(1, currentGame.getBoard().size());
        Assertions.assertEquals(14, player1.getInHand().size());

        player1ChromeDriver.close();
        player2ChromeDriver.close();
        player3EdgeDriver.close();
    }

    @Test
    public void row214() {
        gameService.resetGame();
        WebDriver player1ChromeDriver = webDriverLibrary.getChromeDriver();
        player1ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player1ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        Game currentGame = gameService.getCurrentGame();
        Player player1 = currentGame.getPlayerByNumber(1);

        gameService.placeInHand(player1, "R7 R8 R9 R10 R10 R11 R12 B1 B11 B11 B12 B13 G1 G4");

        WebDriver player2ChromeDriver = webDriverLibrary.getChromeDriver();
        player2ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player2ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnJoinGame")).click();

        WebDriver player3EdgeDriver = webDriverLibrary.getEdgeDriver();
        player3EdgeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player3EdgeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player3EdgeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-4")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-5")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-6")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();
        wait(waitPerAction);

        player2ChromeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);

        player3EdgeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);


        player1ChromeDriver.findElement(By.id("btnAdd")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-1")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("meld0-tile0")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();

        wait(waitAfterCompletion);
        // invalid
        Assertions.assertEquals(1, currentGame.getBoard().size());
        Assertions.assertEquals(14, player1.getInHand().size());

        player1ChromeDriver.close();
        player2ChromeDriver.close();
        player3EdgeDriver.close();
    }

    @Test
    public void row220() {
        gameService.resetGame();
        WebDriver player1ChromeDriver = webDriverLibrary.getChromeDriver();
        player1ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player1ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        Game currentGame = gameService.getCurrentGame();
        Player player1 = currentGame.getPlayerByNumber(1);

        gameService.placeInHand(player1, "R7 R8 R9 R10 R10 R11 R12 B1 B11 B11 B12 B13 G1 G4");

        WebDriver player2ChromeDriver = webDriverLibrary.getChromeDriver();
        player2ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player2ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnJoinGame")).click();

        WebDriver player3EdgeDriver = webDriverLibrary.getEdgeDriver();
        player3EdgeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player3EdgeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player3EdgeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-4")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-5")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-6")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();
        wait(waitPerAction);

        player2ChromeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);

        player3EdgeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);


        player1ChromeDriver.findElement(By.id("btnAdd")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-3")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("meld0-tile0")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();

        wait(waitAfterCompletion);
        // invalid
        Assertions.assertEquals(1, currentGame.getBoard().size());
        Assertions.assertEquals(14, player1.getInHand().size());

        player1ChromeDriver.close();
        player2ChromeDriver.close();
        player3EdgeDriver.close();
    }

    @Test
    public void row226() {
        gameService.resetGame();
        WebDriver player1ChromeDriver = webDriverLibrary.getChromeDriver();
        player1ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player1ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        Game currentGame = gameService.getCurrentGame();
        Player player1 = currentGame.getPlayerByNumber(1);

        gameService.placeInHand(player1, "R7 R8 R9 R10 R10 R11 R12 B1 B11 B11 B12 B13 G1 G4");

        WebDriver player2ChromeDriver = webDriverLibrary.getChromeDriver();
        player2ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player2ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnJoinGame")).click();

        WebDriver player3EdgeDriver = webDriverLibrary.getEdgeDriver();
        player3EdgeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player3EdgeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player3EdgeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-4")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-5")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-6")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();
        wait(waitPerAction);

        player2ChromeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);

        player3EdgeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);


        player1ChromeDriver.findElement(By.id("btnAdd")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-2")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("meld0-tile0")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();

        wait(waitAfterCompletion);
        // valid
        Assertions.assertEquals(1, currentGame.getBoard().size());
        Assertions.assertTrue(player1.getInHand().size() < 11);

        player1ChromeDriver.close();
        player2ChromeDriver.close();
        player3EdgeDriver.close();
    }

    @Test
    public void row232() {
        gameService.resetGame();
        WebDriver player1ChromeDriver = webDriverLibrary.getChromeDriver();
        player1ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player1ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        Game currentGame = gameService.getCurrentGame();
        Player player1 = currentGame.getPlayerByNumber(1);

        gameService.placeInHand(player1, "R7 R8 R9 R10 R10 R11 R12 B1 B11 B11 B12 B13 G1 G4");

        WebDriver player2ChromeDriver = webDriverLibrary.getChromeDriver();
        player2ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player2ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnJoinGame")).click();

        WebDriver player3EdgeDriver = webDriverLibrary.getEdgeDriver();
        player3EdgeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player3EdgeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player3EdgeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-4")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-5")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-6")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();
        wait(waitPerAction);

        player2ChromeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);

        player3EdgeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);


        player1ChromeDriver.findElement(By.id("btnAdd")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-1")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-2")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("meld0-tile0")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();

        wait(waitAfterCompletion);
        // valid
        Assertions.assertEquals(1, currentGame.getBoard().size());
        Assertions.assertTrue(player1.getInHand().size() < 11);

        player1ChromeDriver.close();
        player2ChromeDriver.close();
        player3EdgeDriver.close();
    }

    @Test
    public void row239() {
        gameService.resetGame();
        WebDriver player1ChromeDriver = webDriverLibrary.getChromeDriver();
        player1ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player1ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        Game currentGame = gameService.getCurrentGame();
        Player player1 = currentGame.getPlayerByNumber(1);

        gameService.placeInHand(player1, "R7 R8 R9 R10 R11 R11 R12 B1 B11 B11 B12 G11 O1 O11");

        WebDriver player2ChromeDriver = webDriverLibrary.getChromeDriver();
        player2ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player2ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnJoinGame")).click();

        WebDriver player3EdgeDriver = webDriverLibrary.getEdgeDriver();
        player3EdgeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player3EdgeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player3EdgeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-4")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-8")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-11")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();
        wait(waitPerAction);

        player2ChromeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);

        player3EdgeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);


        player1ChromeDriver.findElement(By.id("btnAdd")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-9")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("meld0-tile2")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();

        wait(waitAfterCompletion);
        // invalid
        Assertions.assertEquals(1, currentGame.getBoard().size());
        Assertions.assertEquals(14, player1.getInHand().size());

        player1ChromeDriver.close();
        player2ChromeDriver.close();
        player3EdgeDriver.close();
    }

    @Test
    public void row245() {
        gameService.resetGame();
        WebDriver player1ChromeDriver = webDriverLibrary.getChromeDriver();
        player1ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player1ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        Game currentGame = gameService.getCurrentGame();
        Player player1 = currentGame.getPlayerByNumber(1);

        gameService.placeInHand(player1, "R7 R8 R9 R10 R11 R11 R12 B1 B11 B11 B12 G11 O1 O11");

        WebDriver player2ChromeDriver = webDriverLibrary.getChromeDriver();
        player2ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player2ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnJoinGame")).click();

        WebDriver player3EdgeDriver = webDriverLibrary.getEdgeDriver();
        player3EdgeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player3EdgeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player3EdgeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-4")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-8")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-11")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();
        wait(waitPerAction);

        player2ChromeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);

        player3EdgeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);


        player1ChromeDriver.findElement(By.id("btnAdd")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-4")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-10")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("meld0-tile2")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();

        wait(waitAfterCompletion);
        // invalid
        Assertions.assertEquals(1, currentGame.getBoard().size());
        Assertions.assertEquals(14, player1.getInHand().size());

        player1ChromeDriver.close();
        player2ChromeDriver.close();
        player3EdgeDriver.close();
    }

    @Test
    public void row251() {
        gameService.resetGame();
        WebDriver player1ChromeDriver = webDriverLibrary.getChromeDriver();
        player1ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player1ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        Game currentGame = gameService.getCurrentGame();
        Player player1 = currentGame.getPlayerByNumber(1);

        gameService.placeInHand(player1, "R7 R8 R9 R10 R11 R11 R12 B1 B11 B11 B12 G11 O1 O11");

        WebDriver player2ChromeDriver = webDriverLibrary.getChromeDriver();
        player2ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player2ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnJoinGame")).click();

        WebDriver player3EdgeDriver = webDriverLibrary.getEdgeDriver();
        player3EdgeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player3EdgeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player3EdgeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-4")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-8")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-11")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();
        wait(waitPerAction);

        player2ChromeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);

        player3EdgeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);


        player1ChromeDriver.findElement(By.id("btnAdd")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-10")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("meld0-tile2")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();

        wait(waitAfterCompletion);
        // valid
        Assertions.assertEquals(1, currentGame.getBoard().size());
        Assertions.assertEquals(10, player1.getInHand().size());

        player1ChromeDriver.close();
        player2ChromeDriver.close();
        player3EdgeDriver.close();
    }

    @Test
    public void row258() {
        gameService.resetGame();
        WebDriver player1ChromeDriver = webDriverLibrary.getChromeDriver();
        player1ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player1ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        Game currentGame = gameService.getCurrentGame();
        Player player1 = currentGame.getPlayerByNumber(1);

        gameService.placeInHand(player1, "R7 R8 R9 R10 R10 R11 R12 B1 B11 B11 B12 B13 G1 *");

        WebDriver player2ChromeDriver = webDriverLibrary.getChromeDriver();
        player2ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player2ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnJoinGame")).click();

        WebDriver player3EdgeDriver = webDriverLibrary.getEdgeDriver();
        player3EdgeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player3EdgeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player3EdgeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-4")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-5")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-6")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();
        wait(waitPerAction);

        player2ChromeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);

        player3EdgeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);


        player1ChromeDriver.findElement(By.id("btnAdd")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-10")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("meld0-tile0")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();

        wait(waitAfterCompletion);
        // valid
        Assertions.assertEquals(1, currentGame.getBoard().size());
        Assertions.assertTrue(player1.getInHand().size() < 11);

        player1ChromeDriver.close();
        player2ChromeDriver.close();
        player3EdgeDriver.close();
    }

    @Test
    public void row264() {
        gameService.resetGame();
        WebDriver player1ChromeDriver = webDriverLibrary.getChromeDriver();
        player1ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player1ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        Game currentGame = gameService.getCurrentGame();
        Player player1 = currentGame.getPlayerByNumber(1);

        gameService.placeInHand(player1, "R7 R8 R9 R10 R10 R11 R12 B1 B11 B11 B12 B13 G1 *");

        WebDriver player2ChromeDriver = webDriverLibrary.getChromeDriver();
        player2ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player2ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnJoinGame")).click();

        WebDriver player3EdgeDriver = webDriverLibrary.getEdgeDriver();
        player3EdgeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player3EdgeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player3EdgeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-4")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-5")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-6")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();
        wait(waitPerAction);

        player2ChromeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);

        player3EdgeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);


        player1ChromeDriver.findElement(By.id("btnAdd")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-1")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-10")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("meld0-tile0")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();

        wait(waitAfterCompletion);
        // valid
        Assertions.assertEquals(1, currentGame.getBoard().size());
        Assertions.assertTrue(player1.getInHand().size() < 11);

        player1ChromeDriver.close();
        player2ChromeDriver.close();
        player3EdgeDriver.close();
    }

    @Test
    public void row270() {
        gameService.resetGame();
        WebDriver player1ChromeDriver = webDriverLibrary.getChromeDriver();
        player1ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player1ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        Game currentGame = gameService.getCurrentGame();
        Player player1 = currentGame.getPlayerByNumber(1);

        gameService.placeInHand(player1, "R7 R8 R9 R10 R11 R11 R12 B1 B11 B11 B12 G11 O11 *");

        WebDriver player2ChromeDriver = webDriverLibrary.getChromeDriver();
        player2ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player2ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnJoinGame")).click();

        WebDriver player3EdgeDriver = webDriverLibrary.getEdgeDriver();
        player3EdgeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player3EdgeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player3EdgeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-4")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-8")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-11")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-12")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();
        wait(waitPerAction);

        player2ChromeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);

        player3EdgeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);


        player1ChromeDriver.findElement(By.id("btnAdd")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-9")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("meld0-tile2")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();

        wait(waitAfterCompletion);
        // invalid
        Assertions.assertEquals(1, currentGame.getBoard().size());
        Assertions.assertEquals(13, player1.getInHand().size());

        player1ChromeDriver.close();
        player2ChromeDriver.close();
        player3EdgeDriver.close();
    }

    @Test
    public void row276() {
        gameService.resetGame();
        WebDriver player1ChromeDriver = webDriverLibrary.getChromeDriver();
        player1ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player1ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        Game currentGame = gameService.getCurrentGame();
        Player player1 = currentGame.getPlayerByNumber(1);

        gameService.placeInHand(player1, "R7 R8 R9 R10 R11 R11 R12 B1 B11 B11 B12 G11 O11 *");

        WebDriver player2ChromeDriver = webDriverLibrary.getChromeDriver();
        player2ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player2ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnJoinGame")).click();

        WebDriver player3EdgeDriver = webDriverLibrary.getEdgeDriver();
        player3EdgeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player3EdgeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player3EdgeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-4")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-8")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-11")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();
        wait(waitPerAction);

        player2ChromeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);

        player3EdgeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);


        player1ChromeDriver.findElement(By.id("btnAdd")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-10")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("meld0-tile2")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();

        wait(waitAfterCompletion);
        // valid
        Assertions.assertEquals(1, currentGame.getBoard().size());
        Assertions.assertEquals(10, player1.getInHand().size());

        player1ChromeDriver.close();
        player2ChromeDriver.close();
        player3EdgeDriver.close();
    }

    @Test
    public void row283() {
        gameService.resetGame();
        WebDriver player1ChromeDriver = webDriverLibrary.getChromeDriver();
        player1ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player1ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        Game currentGame = gameService.getCurrentGame();
        Player player1 = currentGame.getPlayerByNumber(1);

        gameService.placeInHand(player1, "R3 R4 R4 R5 R5 R6 R6 R7 R7 R8 R11 B11 G11 *");

        WebDriver player2ChromeDriver = webDriverLibrary.getChromeDriver();
        player2ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player2ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnJoinGame")).click();

        WebDriver player3EdgeDriver = webDriverLibrary.getEdgeDriver();
        player3EdgeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player3EdgeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player3EdgeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-0")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-1")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-3")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-5")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-7")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-9")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();
        wait(waitPerAction);

        player2ChromeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);

        player3EdgeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);


        player1ChromeDriver.findElement(By.id("btnBreak")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("meld0-tile2")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnAdd")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-0")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("meld0-tile2")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();

        wait(waitAfterCompletion);
        // invalid
        Assertions.assertEquals(1, currentGame.getBoard().size());
        Assertions.assertTrue(player1.getInHand().size() > 8);

        player1ChromeDriver.close();
        player2ChromeDriver.close();
        player3EdgeDriver.close();
    }

    @Test
    public void row289() {
        gameService.resetGame();
        WebDriver player1ChromeDriver = webDriverLibrary.getChromeDriver();
        player1ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player1ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        Game currentGame = gameService.getCurrentGame();
        Player player1 = currentGame.getPlayerByNumber(1);

        gameService.placeInHand(player1, "R3 R4 R4 R5 R5 R6 R6 R7 R7 R8 R11 B11 G11 *");

        WebDriver player2ChromeDriver = webDriverLibrary.getChromeDriver();
        player2ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player2ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnJoinGame")).click();

        WebDriver player3EdgeDriver = webDriverLibrary.getEdgeDriver();
        player3EdgeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player3EdgeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player3EdgeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-0")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-1")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-3")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-5")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-7")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-9")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();
        wait(waitPerAction);

        player2ChromeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);

        player3EdgeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);


        player1ChromeDriver.findElement(By.id("btnBreak")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("meld0-tile2")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnAdd")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-3")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("meld1-tile0")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();

        wait(waitAfterCompletion);
        // invalid
        Assertions.assertEquals(1, currentGame.getBoard().size());
        Assertions.assertTrue(player1.getInHand().size() > 8);

        player1ChromeDriver.close();
        player2ChromeDriver.close();
        player3EdgeDriver.close();
    }

    @Test
    public void row295() {
        gameService.resetGame();
        WebDriver player1ChromeDriver = webDriverLibrary.getChromeDriver();
        player1ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player1ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        Game currentGame = gameService.getCurrentGame();
        Player player1 = currentGame.getPlayerByNumber(1);

        gameService.placeInHand(player1, "R3 R4 R4 R5 R5 R6 R6 R7 R7 R8 R11 B11 G11 *");

        WebDriver player2ChromeDriver = webDriverLibrary.getChromeDriver();
        player2ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player2ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnJoinGame")).click();

        WebDriver player3EdgeDriver = webDriverLibrary.getEdgeDriver();
        player3EdgeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player3EdgeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player3EdgeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-0")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-1")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-3")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-5")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-7")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-9")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();
        wait(waitPerAction);

        player2ChromeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);

        player3EdgeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);


        player1ChromeDriver.findElement(By.id("btnBreak")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("meld0-tile2")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnAdd")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-1")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("meld1-tile0")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();

        wait(waitAfterCompletion);
        // valid
        Assertions.assertEquals(2, currentGame.getBoard().size());
        Assertions.assertTrue(player1.getInHand().size() < 8);

        player1ChromeDriver.close();
        player2ChromeDriver.close();
        player3EdgeDriver.close();
    }

    @Test
    public void row301() {
        gameService.resetGame();
        WebDriver player1ChromeDriver = webDriverLibrary.getChromeDriver();
        player1ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player1ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        Game currentGame = gameService.getCurrentGame();
        Player player1 = currentGame.getPlayerByNumber(1);

        gameService.placeInHand(player1, "R3 R4 R4 R5 R5 R6 R6 R7 R7 R8 R11 B11 G11 *");

        WebDriver player2ChromeDriver = webDriverLibrary.getChromeDriver();
        player2ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player2ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnJoinGame")).click();

        WebDriver player3EdgeDriver = webDriverLibrary.getEdgeDriver();
        player3EdgeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player3EdgeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player3EdgeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-0")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-1")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-3")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-5")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-7")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-9")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();
        wait(waitPerAction);

        player2ChromeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);

        player3EdgeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);


        player1ChromeDriver.findElement(By.id("btnBreak")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("meld0-tile2")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnAdd")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-2")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("meld0-tile2")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();

        wait(waitAfterCompletion);
        // valid
        Assertions.assertEquals(2, currentGame.getBoard().size());
        Assertions.assertTrue(player1.getInHand().size() < 8);

        player1ChromeDriver.close();
        player2ChromeDriver.close();
        player3EdgeDriver.close();
    }

    @Test
    public void row307() {
        gameService.resetGame();
        WebDriver player1ChromeDriver = webDriverLibrary.getChromeDriver();
        player1ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player1ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        Game currentGame = gameService.getCurrentGame();
        Player player1 = currentGame.getPlayerByNumber(1);

        gameService.placeInHand(player1, "R3 R4 R4 R5 R5 R6 R6 R7 R7 R8 R11 B11 G11 *");

        WebDriver player2ChromeDriver = webDriverLibrary.getChromeDriver();
        player2ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player2ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnJoinGame")).click();

        WebDriver player3EdgeDriver = webDriverLibrary.getEdgeDriver();
        player3EdgeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player3EdgeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player3EdgeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-0")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-1")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-3")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-5")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-7")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-9")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();
        wait(waitPerAction);

        player2ChromeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);

        player3EdgeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);


        player1ChromeDriver.findElement(By.id("btnBreak")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("meld0-tile4")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnAdd")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-3")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("meld1-tile0")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();

        wait(waitAfterCompletion);
        // invalid
        Assertions.assertEquals(1, currentGame.getBoard().size());
        Assertions.assertTrue(player1.getInHand().size() > 8);

        player1ChromeDriver.close();
        player2ChromeDriver.close();
        player3EdgeDriver.close();
    }

    @Test
    public void row313() {
        gameService.resetGame();
        WebDriver player1ChromeDriver = webDriverLibrary.getChromeDriver();
        player1ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player1ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        Game currentGame = gameService.getCurrentGame();
        Player player1 = currentGame.getPlayerByNumber(1);

        gameService.placeInHand(player1, "R3 R4 R4 R5 R5 R6 R6 R7 R7 R8 R11 B11 G11 *");

        WebDriver player2ChromeDriver = webDriverLibrary.getChromeDriver();
        player2ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player2ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnJoinGame")).click();

        WebDriver player3EdgeDriver = webDriverLibrary.getEdgeDriver();
        player3EdgeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player3EdgeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player3EdgeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-0")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-1")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-3")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-5")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-7")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-9")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();
        wait(waitPerAction);

        player2ChromeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);

        player3EdgeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);


        player1ChromeDriver.findElement(By.id("btnBreak")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("meld0-tile2")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnAdd")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-7")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("meld0-tile2")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();

        wait(waitAfterCompletion);
        // valid
        Assertions.assertEquals(2, currentGame.getBoard().size());
        Assertions.assertTrue(player1.getInHand().size() < 8);

        player1ChromeDriver.close();
        player2ChromeDriver.close();
        player3EdgeDriver.close();
    }

    @Test
    public void row320() {
        gameService.resetGame();
        WebDriver player1ChromeDriver = webDriverLibrary.getChromeDriver();
        player1ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player1ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        Game currentGame = gameService.getCurrentGame();
        Player player1 = currentGame.getPlayerByNumber(1);

        gameService.placeInHand(player1, "R1 R2 R3 R4 R9 R11 R11 B11 B11 G11 G11 O11 O11 *");

        WebDriver player2ChromeDriver = webDriverLibrary.getChromeDriver();
        player2ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player2ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnJoinGame")).click();

        WebDriver player3EdgeDriver = webDriverLibrary.getEdgeDriver();
        player3EdgeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player3EdgeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player3EdgeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-5")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-7")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-9")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-11")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();
        wait(waitPerAction);

        player2ChromeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);

        player3EdgeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);


        player1ChromeDriver.findElement(By.id("btnBreak")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("meld0-tile1")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnAdd")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-4")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("meld0-tile1")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();

        wait(waitAfterCompletion);
        // invalid
        Assertions.assertEquals(1, currentGame.getBoard().size());
        Assertions.assertTrue(player1.getInHand().size() > 10);

        player1ChromeDriver.close();
        player2ChromeDriver.close();
        player3EdgeDriver.close();
    }

    @Test
    public void row326() {
        gameService.resetGame();
        WebDriver player1ChromeDriver = webDriverLibrary.getChromeDriver();
        player1ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player1ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        Game currentGame = gameService.getCurrentGame();
        Player player1 = currentGame.getPlayerByNumber(1);

        gameService.placeInHand(player1, "R1 R2 R3 R4 R9 R11 R11 B11 B11 G11 G11 O11 O11 *");

        WebDriver player2ChromeDriver = webDriverLibrary.getChromeDriver();
        player2ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player2ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnJoinGame")).click();

        WebDriver player3EdgeDriver = webDriverLibrary.getEdgeDriver();
        player3EdgeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player3EdgeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player3EdgeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-5")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-7")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-9")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-11")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();
        wait(waitPerAction);

        player2ChromeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);

        player3EdgeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);


        player1ChromeDriver.findElement(By.id("btnBreak")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("meld0-tile1")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnAdd")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-5")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("meld0-tile1")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();

        wait(waitAfterCompletion);
        // invalid
        Assertions.assertEquals(1, currentGame.getBoard().size());
        Assertions.assertTrue(player1.getInHand().size() > 10);

        player1ChromeDriver.close();
        player2ChromeDriver.close();
        player3EdgeDriver.close();
    }

    @Test
    public void row332() {
        gameService.resetGame();
        WebDriver player1ChromeDriver = webDriverLibrary.getChromeDriver();
        player1ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player1ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        Game currentGame = gameService.getCurrentGame();
        Player player1 = currentGame.getPlayerByNumber(1);

        gameService.placeInHand(player1, "R1 R2 R3 R4 R9 R11 R11 B11 B11 G11 G11 O11 O11 *");

        WebDriver player2ChromeDriver = webDriverLibrary.getChromeDriver();
        player2ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player2ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnJoinGame")).click();

        WebDriver player3EdgeDriver = webDriverLibrary.getEdgeDriver();
        player3EdgeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player3EdgeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player3EdgeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-5")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-7")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-9")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-11")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();
        wait(waitPerAction);

        player2ChromeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);

        player3EdgeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);


        player1ChromeDriver.findElement(By.id("btnBreak")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("meld0-tile2")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnAdd")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-8")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("meld0-tile2")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();

        wait(waitAfterCompletion);
        // invalid
        Assertions.assertEquals(1, currentGame.getBoard().size());
        Assertions.assertTrue(player1.getInHand().size() > 10);

        player1ChromeDriver.close();
        player2ChromeDriver.close();
        player3EdgeDriver.close();
    }

    @Test
    public void row338() {
        gameService.resetGame();
        WebDriver player1ChromeDriver = webDriverLibrary.getChromeDriver();
        player1ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player1ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        Game currentGame = gameService.getCurrentGame();
        Player player1 = currentGame.getPlayerByNumber(1);

        gameService.placeInHand(player1, "R1 R2 R3 R4 R9 R11 R11 B11 B11 G11 G11 O11 O11 *");

        WebDriver player2ChromeDriver = webDriverLibrary.getChromeDriver();
        player2ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player2ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnJoinGame")).click();

        WebDriver player3EdgeDriver = webDriverLibrary.getEdgeDriver();
        player3EdgeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player3EdgeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player3EdgeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-5")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-7")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-9")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-11")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();
        wait(waitPerAction);

        player2ChromeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);

        player3EdgeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);


        player1ChromeDriver.findElement(By.id("btnBreak")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("meld0-tile1")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnAdd")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-7")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("meld0-tile1")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnAdd")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-6")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("meld1-tile0")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();

        wait(waitAfterCompletion);
        // valid
        Assertions.assertEquals(2, currentGame.getBoard().size());
        Assertions.assertTrue(player1.getInHand().size() < 10);

        player1ChromeDriver.close();
        player2ChromeDriver.close();
        player3EdgeDriver.close();
    }

    @Test
    public void row344() {
        gameService.resetGame();
        WebDriver player1ChromeDriver = webDriverLibrary.getChromeDriver();
        player1ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player1ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        Game currentGame = gameService.getCurrentGame();
        Player player1 = currentGame.getPlayerByNumber(1);

        gameService.placeInHand(player1, "R1 R2 R3 R4 R9 R11 R11 B11 B11 G11 G11 O11 O11 *");

        WebDriver player2ChromeDriver = webDriverLibrary.getChromeDriver();
        player2ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player2ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnJoinGame")).click();

        WebDriver player3EdgeDriver = webDriverLibrary.getEdgeDriver();
        player3EdgeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player3EdgeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player3EdgeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-5")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-7")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-9")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-11")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();
        wait(waitPerAction);

        player2ChromeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);

        player3EdgeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);


        player1ChromeDriver.findElement(By.id("btnBreak")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("meld0-tile1")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnAdd")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-9")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("meld0-tile1")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnAdd")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-6")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("meld1-tile0")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();

        wait(waitAfterCompletion);
        // valid
        Assertions.assertEquals(2, currentGame.getBoard().size());
        Assertions.assertTrue(player1.getInHand().size() < 10);

        player1ChromeDriver.close();
        player2ChromeDriver.close();
        player3EdgeDriver.close();
    }

    @Test
    public void row353() {
        gameService.resetGame();
        WebDriver player1ChromeDriver = webDriverLibrary.getChromeDriver();
        player1ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player1ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        Game currentGame = gameService.getCurrentGame();
        Player player1 = currentGame.getPlayerByNumber(1);

        gameService.placeInHand(player1, "R5 R6 R7 R8 R9 R10 R11 R11 R12 R13 B11 G11 O11 *");

        WebDriver player2ChromeDriver = webDriverLibrary.getChromeDriver();
        player2ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player2ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnJoinGame")).click();

        Player player2 = currentGame.getPlayerByNumber(2);

        gameService.placeInHand(player2, "R8 R9 R12 R13 B7 B11 B11 B12 G7 G11 G12 O7 O12 *");

        WebDriver player3EdgeDriver = webDriverLibrary.getEdgeDriver();
        player3EdgeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player3EdgeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player3EdgeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-6")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-10")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-11")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-12")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-2")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-3")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-4")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-5")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-6")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-7")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-8")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();
        wait(waitPerAction);

        player2ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("inHand-7")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("inHand-10")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("inHand-12")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnEndTurn")).click();
        wait(waitPerAction);

        player3EdgeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);

        player1ChromeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);

        player2ChromeDriver.findElement(By.id("btnBreak")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("meld0-tile0")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnAdd")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("inHand-5")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("inHand-8")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("meld2-tile0")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnEndTurn")).click();

        wait(waitAfterCompletion);
        // valid
        Assertions.assertTrue(player2.getInHand().size() < 11);

        player1ChromeDriver.close();
        player2ChromeDriver.close();
        player3EdgeDriver.close();
    }

    @Test
    public void row359() {
        gameService.resetGame();
        WebDriver player1ChromeDriver = webDriverLibrary.getChromeDriver();
        player1ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player1ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        Game currentGame = gameService.getCurrentGame();
        Player player1 = currentGame.getPlayerByNumber(1);

        gameService.placeInHand(player1, "R5 R6 R7 R8 R9 R10 R11 R11 R12 R13 B11 G11 O11 *");

        WebDriver player2ChromeDriver = webDriverLibrary.getChromeDriver();
        player2ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player2ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnJoinGame")).click();

        Player player2 = currentGame.getPlayerByNumber(2);

        gameService.placeInHand(player2, "R8 R9 R12 R13 B7 B11 B11 B12 G7 G11 G12 O7 O12 *");

        WebDriver player3EdgeDriver = webDriverLibrary.getEdgeDriver();
        player3EdgeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player3EdgeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player3EdgeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-6")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-10")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-11")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-12")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-2")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-3")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-4")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-5")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-6")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-7")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-8")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();
        wait(waitPerAction);

        player2ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("inHand-7")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("inHand-10")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("inHand-12")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnEndTurn")).click();
        wait(waitPerAction);

        player3EdgeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);

        player1ChromeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);

        player2ChromeDriver.findElement(By.id("btnBreak")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("meld0-tile0")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnAdd")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("inHand-2")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("inHand-3")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("meld2-tile0")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnBreak")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("meld2-tile1")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnMerge")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("meld3-tile0")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("meld4-tile0")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnEndTurn")).click();

        wait(waitAfterCompletion);
        // valid
        Assertions.assertTrue(player2.getInHand().size() < 11);

        player1ChromeDriver.close();
        player2ChromeDriver.close();
        player3EdgeDriver.close();
    }

    @Test
    public void row365() {
        gameService.resetGame();
        WebDriver player1ChromeDriver = webDriverLibrary.getChromeDriver();
        player1ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player1ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        Game currentGame = gameService.getCurrentGame();
        Player player1 = currentGame.getPlayerByNumber(1);

        gameService.placeInHand(player1, "R5 R6 R7 R8 R9 R10 R11 R11 R12 R13 B11 G11 O11 *");

        WebDriver player2ChromeDriver = webDriverLibrary.getChromeDriver();
        player2ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player2ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnJoinGame")).click();

        Player player2 = currentGame.getPlayerByNumber(2);

        gameService.placeInHand(player2, "R8 R9 R12 R13 B7 B11 B11 B12 G7 G11 G12 O7 O12 *");

        WebDriver player3EdgeDriver = webDriverLibrary.getEdgeDriver();
        player3EdgeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player3EdgeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player3EdgeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-6")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-10")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-11")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-12")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-2")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-3")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-4")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-5")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-6")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-7")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-8")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();
        wait(waitPerAction);

        player2ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("inHand-7")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("inHand-10")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("inHand-12")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnEndTurn")).click();
        wait(waitPerAction);

        player3EdgeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);

        player1ChromeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);

        player2ChromeDriver.findElement(By.id("btnBreak")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("meld1-tile0")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnAdd")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("inHand-4")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("inHand-7")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("meld2-tile0")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnEndTurn")).click();

        wait(waitAfterCompletion);
        // valid
        Assertions.assertTrue(player2.getInHand().size() < 11);

        player1ChromeDriver.close();
        player2ChromeDriver.close();
        player3EdgeDriver.close();
    }

    @Test
    public void row371() {
        gameService.resetGame();
        WebDriver player1ChromeDriver = webDriverLibrary.getChromeDriver();
        player1ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player1ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        Game currentGame = gameService.getCurrentGame();
        Player player1 = currentGame.getPlayerByNumber(1);

        gameService.placeInHand(player1, "R5 R6 R7 R8 R9 R10 R11 R11 R12 R13 B11 G11 O11 *");

        WebDriver player2ChromeDriver = webDriverLibrary.getChromeDriver();
        player2ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player2ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnJoinGame")).click();

        Player player2 = currentGame.getPlayerByNumber(2);

        gameService.placeInHand(player2, "R8 R9 R12 R13 B7 B11 B11 B12 G7 G11 G12 O7 O12 *");

        WebDriver player3EdgeDriver = webDriverLibrary.getEdgeDriver();
        player3EdgeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player3EdgeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player3EdgeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-6")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-10")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-11")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-12")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-2")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-3")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-4")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-5")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-6")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-7")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-8")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();
        wait(waitPerAction);

        player2ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("inHand-7")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("inHand-10")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("inHand-12")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnEndTurn")).click();
        wait(waitPerAction);

        player3EdgeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);

        player1ChromeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);

        player2ChromeDriver.findElement(By.id("btnBreak")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("meld1-tile3")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnBreak")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("meld2-tile2")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnAdd")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("inHand-0")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("inHand-1")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("meld4-tile0")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnEndTurn")).click();

        wait(waitAfterCompletion);
        // valid
        Assertions.assertTrue(player2.getInHand().size() < 11);

        player1ChromeDriver.close();
        player2ChromeDriver.close();
        player3EdgeDriver.close();
    }

    @Test
    public void row377() {
        gameService.resetGame();
        WebDriver player1ChromeDriver = webDriverLibrary.getChromeDriver();
        player1ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player1ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        Game currentGame = gameService.getCurrentGame();
        Player player1 = currentGame.getPlayerByNumber(1);

        gameService.placeInHand(player1, "R5 R6 R7 R8 R9 R10 R11 R11 R12 R13 B11 G11 O11 *");

        WebDriver player2ChromeDriver = webDriverLibrary.getChromeDriver();
        player2ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player2ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnJoinGame")).click();

        Player player2 = currentGame.getPlayerByNumber(2);

        gameService.placeInHand(player2, "R8 R9 R12 R13 B7 B11 B11 B12 G7 G11 G12 O7 O12 *");

        WebDriver player3EdgeDriver = webDriverLibrary.getEdgeDriver();
        player3EdgeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player3EdgeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player3EdgeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-6")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-10")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-11")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-12")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-2")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-3")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-4")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-5")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-6")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-7")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-8")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();
        wait(waitPerAction);

        player2ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("inHand-7")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("inHand-10")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("inHand-12")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnEndTurn")).click();
        wait(waitPerAction);

        player3EdgeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);

        player1ChromeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);

        player2ChromeDriver.findElement(By.id("btnBreak")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("meld0-tile0")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnAdd")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("inHand-5")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("inHand-10")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("meld2-tile0")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnEndTurn")).click();

        wait(waitAfterCompletion);
        // valid
        Assertions.assertTrue(player2.getInHand().size() < 11);

        player1ChromeDriver.close();
        player2ChromeDriver.close();
        player3EdgeDriver.close();
    }

    @Test
    public void row383() {
        gameService.resetGame();
        WebDriver player1ChromeDriver = webDriverLibrary.getChromeDriver();
        player1ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player1ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        Game currentGame = gameService.getCurrentGame();
        Player player1 = currentGame.getPlayerByNumber(1);

        gameService.placeInHand(player1, "R5 R6 R7 R8 R9 R10 R11 R11 R12 R13 B11 G11 O11 *");

        WebDriver player2ChromeDriver = webDriverLibrary.getChromeDriver();
        player2ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player2ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnJoinGame")).click();

        Player player2 = currentGame.getPlayerByNumber(2);

        gameService.placeInHand(player2, "R8 R9 R12 R13 B7 B11 B11 B12 G7 G11 G12 O7 O12 *");

        WebDriver player3EdgeDriver = webDriverLibrary.getEdgeDriver();
        player3EdgeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player3EdgeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player3EdgeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-6")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-10")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-11")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-12")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-2")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-3")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-4")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-5")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-6")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-7")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-8")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();
        wait(waitPerAction);

        player2ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("inHand-7")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("inHand-10")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("inHand-12")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnEndTurn")).click();
        wait(waitPerAction);

        player3EdgeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);

        player1ChromeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);

        player2ChromeDriver.findElement(By.id("btnBreak")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("meld0-tile0")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnAdd")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("inHand-10")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("inHand-3")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("meld2-tile0")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnBreak")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("meld2-tile1")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnMerge")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("meld3-tile0")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("meld4-tile0")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnEndTurn")).click();

        wait(waitAfterCompletion);
        // valid
        Assertions.assertTrue(player2.getInHand().size() < 11);

        player1ChromeDriver.close();
        player2ChromeDriver.close();
        player3EdgeDriver.close();
    }

    @Test
    public void row389() {
        gameService.resetGame();
        WebDriver player1ChromeDriver = webDriverLibrary.getChromeDriver();
        player1ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player1ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        Game currentGame = gameService.getCurrentGame();
        Player player1 = currentGame.getPlayerByNumber(1);

        gameService.placeInHand(player1, "R5 R6 R7 R8 R9 R10 R11 R11 R12 R13 B11 G11 O11 *");

        WebDriver player2ChromeDriver = webDriverLibrary.getChromeDriver();
        player2ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player2ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnJoinGame")).click();

        Player player2 = currentGame.getPlayerByNumber(2);

        gameService.placeInHand(player2, "R8 R9 R12 R13 B7 B11 B11 B12 G7 G11 G12 O7 O12 *");

        WebDriver player3EdgeDriver = webDriverLibrary.getEdgeDriver();
        player3EdgeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player3EdgeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player3EdgeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-6")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-10")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-11")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-12")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-2")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-3")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-4")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-5")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-6")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-7")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-8")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();
        wait(waitPerAction);

        player2ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("inHand-7")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("inHand-10")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("inHand-12")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnEndTurn")).click();
        wait(waitPerAction);

        player3EdgeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);

        player1ChromeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);

        player2ChromeDriver.findElement(By.id("btnBreak")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("meld1-tile0")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnAdd")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("inHand-4")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("inHand-10")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("meld2-tile0")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnEndTurn")).click();

        wait(waitAfterCompletion);
        // valid
        Assertions.assertTrue(player2.getInHand().size() < 11);

        player1ChromeDriver.close();
        player2ChromeDriver.close();
        player3EdgeDriver.close();
    }

    @Test
    public void row395() {
        gameService.resetGame();
        WebDriver player1ChromeDriver = webDriverLibrary.getChromeDriver();
        player1ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player1ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        Game currentGame = gameService.getCurrentGame();
        Player player1 = currentGame.getPlayerByNumber(1);

        gameService.placeInHand(player1, "R5 R6 R7 R8 R9 R10 R11 R11 R12 R13 B11 G11 O11 *");

        WebDriver player2ChromeDriver = webDriverLibrary.getChromeDriver();
        player2ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player2ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnJoinGame")).click();

        Player player2 = currentGame.getPlayerByNumber(2);

        gameService.placeInHand(player2, "R8 R9 R12 R13 B7 B11 B11 B12 G7 G11 G12 O7 O12 *");

        WebDriver player3EdgeDriver = webDriverLibrary.getEdgeDriver();
        player3EdgeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player3EdgeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player3EdgeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-6")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-10")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-11")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-12")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-2")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-3")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-4")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-5")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-6")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-7")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-8")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();
        wait(waitPerAction);

        player2ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("inHand-7")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("inHand-10")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("inHand-12")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnEndTurn")).click();
        wait(waitPerAction);

        player3EdgeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);

        player1ChromeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);

        player2ChromeDriver.findElement(By.id("btnBreak")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("meld1-tile3")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnBreak")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("meld2-tile2")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnAdd")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("inHand-0")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("inHand-10")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("meld4-tile0")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnEndTurn")).click();

        wait(waitAfterCompletion);
        // valid
        Assertions.assertTrue(player2.getInHand().size() < 11);

        player1ChromeDriver.close();
        player2ChromeDriver.close();
        player3EdgeDriver.close();
    }

    @Test
    public void row402() {
        gameService.resetGame();
        WebDriver player1ChromeDriver = webDriverLibrary.getChromeDriver();
        player1ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player1ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        Game currentGame = gameService.getCurrentGame();
        Player player1 = currentGame.getPlayerByNumber(1);

        gameService.placeInHand(player1, "R1 R2 R3 R4 R5 R6 R7 R8 R9 R11 B11 G11 O4 O11");

        WebDriver player2ChromeDriver = webDriverLibrary.getChromeDriver();
        player2ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player2ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnJoinGame")).click();

        Player player2 = currentGame.getPlayerByNumber(2);

        gameService.placeInHand(player2, "R4 R5 R6 R7 R12 B1 B2 B3 B4 B4 B5 B12 G4 G12");

        WebDriver player3EdgeDriver = webDriverLibrary.getEdgeDriver();
        player3EdgeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player3EdgeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player3EdgeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-9")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-10")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-11")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-13")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();
        wait(waitPerAction);

        player2ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("inHand-4")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("inHand-11")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("inHand-13")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("inHand-0")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("inHand-7")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("inHand-10")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("inHand-0")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("inHand-1")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("inHand-2")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnEndTurn")).click();
        wait(waitPerAction);

        player3EdgeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);

        player1ChromeDriver.findElement(By.id("btnAdd")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-9")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("meld2-tile0")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnAdd")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-3")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("meld3-tile0")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnAdd")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-6")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("meld3-tile3")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();

        wait(waitAfterCompletion);
        // valid
        Assertions.assertEquals(7, player1.getInHand().size());

        player1ChromeDriver.close();
        player2ChromeDriver.close();
        player3EdgeDriver.close();
    }

    @Test
    public void row408() {
        gameService.resetGame();
        WebDriver player1ChromeDriver = webDriverLibrary.getChromeDriver();
        player1ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player1ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        Game currentGame = gameService.getCurrentGame();
        Player player1 = currentGame.getPlayerByNumber(1);

        gameService.placeInHand(player1, "R11 B11 B12 B13 G1 O1 O2 O3 O4 O5 O6 O7 O8 O11");

        WebDriver player2ChromeDriver = webDriverLibrary.getChromeDriver();
        player2ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player2ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnJoinGame")).click();

        Player player2 = currentGame.getPlayerByNumber(2);

        gameService.placeInHand(player2, "R4 R5 R6 R7 B1 B2 B3 B4 B5 B6 G4 G11 G12 G13");

        WebDriver player3EdgeDriver = webDriverLibrary.getEdgeDriver();
        player3EdgeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player3EdgeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player3EdgeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-0")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-13")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-1")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();
        wait(waitPerAction);

        player2ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("inHand-11")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("inHand-12")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("inHand-13")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("inHand-0")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("inHand-10")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("inHand-7")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("inHand-0")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("inHand-1")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("inHand-2")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnEndTurn")).click();
        wait(waitPerAction);

        player3EdgeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);

        player1ChromeDriver.findElement(By.id("btnBreak")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("meld1-tile0")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnMerge")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("meld0-tile0")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("meld3-tile0")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnAdd")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-2")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("meld3-tile1")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnBreak")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("meld2-tile2")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnAdd")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-0")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-1")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("meld4-tile0")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnBreak")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("meld4-tile1")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnMerge")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("meld4-tile0")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("meld5-tile0")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();

        wait(waitAfterCompletion);
        // valid
        Assertions.assertEquals(8, player1.getInHand().size());

        player1ChromeDriver.close();
        player2ChromeDriver.close();
        player3EdgeDriver.close();
    }

    @Test
    public void row414() {
        gameService.resetGame();
        WebDriver player1ChromeDriver = webDriverLibrary.getChromeDriver();
        player1ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player1ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        Game currentGame = gameService.getCurrentGame();
        Player player1 = currentGame.getPlayerByNumber(1);

        gameService.placeInHand(player1, "R13 B1 B2 B3 B4 B5 B6 B7 B8 B10 B11 G10 G11 O11");

        WebDriver player2ChromeDriver = webDriverLibrary.getChromeDriver();
        player2ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player2ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnJoinGame")).click();

        Player player2 = currentGame.getPlayerByNumber(2);

        gameService.placeInHand(player2, "R7 R8 R9 R10 R11 R12 B12 G1 G2 G3 G4 G5 G12 O12");

        WebDriver player3EdgeDriver = webDriverLibrary.getEdgeDriver();
        player3EdgeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player3EdgeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player3EdgeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-13")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-10")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-11")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();
        wait(waitPerAction);

        player2ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("inHand-13")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("inHand-6")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("inHand-12")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("inHand-0")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("inHand-1")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("inHand-2")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("inHand-3")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("inHand-4")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("inHand-5")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnEndTurn")).click();
        wait(waitPerAction);

        player3EdgeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);

        player1ChromeDriver.findElement(By.id("btnBreak")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("meld2-tile2")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnBreak")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("meld4-tile0")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnAdd")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-10")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-9")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("meld3-tile0")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnAdd")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-0")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("meld4-tile0")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnBreak")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("meld4-tile0")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnMerge")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("meld4-tile0")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("meld5-tile0")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();

        wait(waitAfterCompletion);
        // valid
        Assertions.assertEquals(8, player1.getInHand().size());

        player1ChromeDriver.close();
        player2ChromeDriver.close();
        player3EdgeDriver.close();
    }

    @Test
    public void row420() {
        gameService.resetGame();
        WebDriver player1ChromeDriver = webDriverLibrary.getChromeDriver();
        player1ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player1ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        Game currentGame = gameService.getCurrentGame();
        Player player1 = currentGame.getPlayerByNumber(1);

        gameService.placeInHand(player1, "R3 R4 R5 R11 B1 B2 B3 B4 B4 B11 G4 G11 O5 O13");

        WebDriver player2ChromeDriver = webDriverLibrary.getChromeDriver();
        player2ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player2ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnJoinGame")).click();

        Player player2 = currentGame.getPlayerByNumber(2);

        gameService.placeInHand(player2, "R1 R2 R3 R4 B3 G3 G3 G4 G5 O1 O2 O3 O3 O4");

        WebDriver player3EdgeDriver = webDriverLibrary.getEdgeDriver();
        player3EdgeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player3EdgeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player3EdgeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-3")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-9")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-11")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-0")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-1")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-2")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-0")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-1")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-2")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-3")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();
        wait(waitPerAction);

        player2ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("inHand-9")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("inHand-10")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("inHand-11")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("inHand-13")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("inHand-2")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("inHand-9")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("inHand-4")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("inHand-5")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("inHand-3")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("inHand-4")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("inHand-5")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnEndTurn")).click();
        wait(waitPerAction);

        player3EdgeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);

        player1ChromeDriver.findElement(By.id("btnBreak")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("meld3-tile2")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnAdd")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-1")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-0")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("meld6-tile0")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnAdd")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-1")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("meld5-tile0")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnBreak")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("meld1-tile1")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnBreak")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("meld3-tile1")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnAdd")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-0")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("meld6-tile0")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnMerge")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("meld6-tile1")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("meld8-tile0")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnBreak")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("meld5-tile0")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnBreak")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("meld6-tile0")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnMerge")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("meld9-tile0")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("meld7-tile0")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnBreak")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("meld1-tile2")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnMerge")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("meld9-tile0")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("meld6-tile0")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnBreak")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("meld1-tile1")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnMerge")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("meld9-tile0")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("meld4-tile0")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnBreak")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("meld8-tile0")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnMerge")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("meld8-tile0")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("meld9-tile0")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnMerge")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("meld6-tile0")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("meld8-tile0")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();

        wait(waitAfterCompletion);
        // valid
        Assertions.assertEquals(0, player1.getInHand().size());

        player1ChromeDriver.close();
        player2ChromeDriver.close();
        player3EdgeDriver.close();
    }

    @Test
    public void row427() {
        gameService.resetGame();
        WebDriver player1ChromeDriver = webDriverLibrary.getChromeDriver();
        player1ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player1ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        Game currentGame = gameService.getCurrentGame();
        Player player1 = currentGame.getPlayerByNumber(1);

        gameService.placeInHand(player1, "R1 R6 R8 R9 R11 R11 R12 B2 B2 G2 G11 G11 O11 *");

        WebDriver player2ChromeDriver = webDriverLibrary.getChromeDriver();
        player2ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player2ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnJoinGame")).click();

        WebDriver player3EdgeDriver = webDriverLibrary.getEdgeDriver();
        player3EdgeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player3EdgeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player3EdgeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-2")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-3")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-13")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-4")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-6")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();
        wait(waitPerAction);

        player2ChromeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);

        player3EdgeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);


        player1ChromeDriver.findElement(By.id("btnReplaceJoker")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("meld0-tile2")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-0")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();

        wait(waitAfterCompletion);
        // invalid
        Assertions.assertEquals(1, currentGame.getBoard().size());
        Assertions.assertTrue(player1.getInHand().size() > 9);

        player1ChromeDriver.close();
        player2ChromeDriver.close();
        player3EdgeDriver.close();
    }

    @Test
    public void row433() {
        gameService.resetGame();
        WebDriver player1ChromeDriver = webDriverLibrary.getChromeDriver();
        player1ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player1ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        Game currentGame = gameService.getCurrentGame();
        Player player1 = currentGame.getPlayerByNumber(1);

        gameService.placeInHand(player1, "R1 R6 R8 R9 R11 R11 R12 B2 B2 G2 G11 G11 O11 *");

        WebDriver player2ChromeDriver = webDriverLibrary.getChromeDriver();
        player2ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player2ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnJoinGame")).click();

        WebDriver player3EdgeDriver = webDriverLibrary.getEdgeDriver();
        player3EdgeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player3EdgeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player3EdgeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-2")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-3")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-13")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-4")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-6")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();
        wait(waitPerAction);

        player2ChromeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);

        player3EdgeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);


        player1ChromeDriver.findElement(By.id("btnReplaceJoker")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("meld0-tile2")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-1")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();

        wait(waitAfterCompletion);
        // invalid
        Assertions.assertEquals(1, currentGame.getBoard().size());
        Assertions.assertTrue(player1.getInHand().size() > 9);

        player1ChromeDriver.close();
        player2ChromeDriver.close();
        player3EdgeDriver.close();
    }

    @Test
    public void row440() {
        gameService.resetGame();
        WebDriver player1ChromeDriver = webDriverLibrary.getChromeDriver();
        player1ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player1ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        Game currentGame = gameService.getCurrentGame();
        Player player1 = currentGame.getPlayerByNumber(1);

        gameService.placeInHand(player1, "R1 R6 R8 R9 R11 R11 R12 B2 B2 G2 G11 G11 O11 *");

        WebDriver player2ChromeDriver = webDriverLibrary.getChromeDriver();
        player2ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player2ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnJoinGame")).click();

        WebDriver player3EdgeDriver = webDriverLibrary.getEdgeDriver();
        player3EdgeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player3EdgeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player3EdgeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-4")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-13")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-10")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-12")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();
        wait(waitPerAction);

        player2ChromeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);

        player3EdgeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);


        player1ChromeDriver.findElement(By.id("btnReplaceJoker")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("meld0-tile1")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-6")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();

        wait(waitAfterCompletion);
        // invalid
        Assertions.assertEquals(1, currentGame.getBoard().size());
        Assertions.assertTrue(player1.getInHand().size() > 9);

        player1ChromeDriver.close();
        player2ChromeDriver.close();
        player3EdgeDriver.close();
    }

    @Test
    public void row446() {
        gameService.resetGame();
        WebDriver player1ChromeDriver = webDriverLibrary.getChromeDriver();
        player1ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player1ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        Game currentGame = gameService.getCurrentGame();
        Player player1 = currentGame.getPlayerByNumber(1);

        gameService.placeInHand(player1, "R1 R6 R8 R9 R11 R11 R12 B2 B2 G2 G11 G11 O11 *");

        WebDriver player2ChromeDriver = webDriverLibrary.getChromeDriver();
        player2ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player2ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnJoinGame")).click();

        WebDriver player3EdgeDriver = webDriverLibrary.getEdgeDriver();
        player3EdgeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player3EdgeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player3EdgeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-4")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-13")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-10")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-12")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();
        wait(waitPerAction);

        player2ChromeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);

        player3EdgeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);


        player1ChromeDriver.findElement(By.id("btnReplaceJoker")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("meld0-tile1")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-8")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();

        wait(waitAfterCompletion);
        // invalid
        Assertions.assertEquals(1, currentGame.getBoard().size());
        Assertions.assertTrue(player1.getInHand().size() > 9);

        player1ChromeDriver.close();
        player2ChromeDriver.close();
        player3EdgeDriver.close();
    }

    @Test
    public void row453() {
        gameService.resetGame();
        WebDriver player1ChromeDriver = webDriverLibrary.getChromeDriver();
        player1ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player1ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        Game currentGame = gameService.getCurrentGame();
        Player player1 = currentGame.getPlayerByNumber(1);

        gameService.placeInHand(player1, "R1 R2 R3 R5 R6 R9 B2 B9 B11 G2 G11 O9 O11 *");

        WebDriver player2ChromeDriver = webDriverLibrary.getChromeDriver();
        player2ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player2ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnJoinGame")).click();

        WebDriver player3EdgeDriver = webDriverLibrary.getEdgeDriver();
        player3EdgeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player3EdgeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player3EdgeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-8")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-12")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-13")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-0")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-1")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-2")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();
        wait(waitPerAction);

        player2ChromeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);

        player3EdgeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);


        player1ChromeDriver.findElement(By.id("btnReplaceJoker")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("meld0-tile2")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-6")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnAdd")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-0")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("meld2-tile0")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnBreak")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("meld2-tile0")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();

        wait(waitAfterCompletion);
        // invalid
        Assertions.assertEquals(2, currentGame.getBoard().size());
        Assertions.assertTrue(player1.getInHand().size() > 9);

        player1ChromeDriver.close();
        player2ChromeDriver.close();
        player3EdgeDriver.close();
    }

    @Test
    public void row460() {
        gameService.resetGame();
        WebDriver player1ChromeDriver = webDriverLibrary.getChromeDriver();
        player1ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player1ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        Game currentGame = gameService.getCurrentGame();
        Player player1 = currentGame.getPlayerByNumber(1);

        gameService.placeInHand(player1, "R1 R2 R3 R5 R6 R9 B2 B9 B11 G2 G11 O9 O11 *");

        WebDriver player2ChromeDriver = webDriverLibrary.getChromeDriver();
        player2ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player2ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnJoinGame")).click();

        WebDriver player3EdgeDriver = webDriverLibrary.getEdgeDriver();
        player3EdgeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player3EdgeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player3EdgeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-8")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-12")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-13")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-5")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-7")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-10")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();
        wait(waitPerAction);

        player2ChromeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);

        player3EdgeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);


        player1ChromeDriver.findElement(By.id("btnReplaceJoker")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("meld0-tile2")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-7")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnMerge")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("meld1-tile0")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("meld2-tile0")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();

        wait(waitAfterCompletion);
        // invalid
        Assertions.assertEquals(2, currentGame.getBoard().size());
        Assertions.assertTrue(player1.getInHand().size() > 9);

        player1ChromeDriver.close();
        player2ChromeDriver.close();
        player3EdgeDriver.close();
    }

    @Test
    public void row467() {
        gameService.resetGame();
        WebDriver player1ChromeDriver = webDriverLibrary.getChromeDriver();
        player1ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player1ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        Game currentGame = gameService.getCurrentGame();
        Player player1 = currentGame.getPlayerByNumber(1);

        gameService.placeInHand(player1, "R1 R2 R3 R5 R6 R9 B2 B9 B11 G2 G11 O9 O11 *");

        WebDriver player2ChromeDriver = webDriverLibrary.getChromeDriver();
        player2ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player2ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnJoinGame")).click();

        WebDriver player3EdgeDriver = webDriverLibrary.getEdgeDriver();
        player3EdgeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player3EdgeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player3EdgeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-8")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-12")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-13")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-0")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-1")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-2")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();
        wait(waitPerAction);

        player2ChromeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);

        player3EdgeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);


        player1ChromeDriver.findElement(By.id("btnReplaceJoker")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("meld0-tile2")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-6")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnAdd")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-0")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-1")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("meld2-tile0")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();

        wait(waitAfterCompletion);
        // valid
        Assertions.assertTrue(currentGame.getBoard().size() > 2);
        Assertions.assertTrue(player1.getInHand().size() < 9);

        player1ChromeDriver.close();
        player2ChromeDriver.close();
        player3EdgeDriver.close();
    }

    @Test
    public void row474() {
        gameService.resetGame();
        WebDriver player1ChromeDriver = webDriverLibrary.getChromeDriver();
        player1ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player1ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        Game currentGame = gameService.getCurrentGame();
        Player player1 = currentGame.getPlayerByNumber(1);

        gameService.placeInHand(player1, "R1 R2 R3 R5 R6 R9 B2 B9 B11 G2 G11 O9 O11 *");

        WebDriver player2ChromeDriver = webDriverLibrary.getChromeDriver();
        player2ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player2ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnJoinGame")).click();

        WebDriver player3EdgeDriver = webDriverLibrary.getEdgeDriver();
        player3EdgeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player3EdgeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player3EdgeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-8")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-12")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-13")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-1")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-6")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-8")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();
        wait(waitPerAction);

        player2ChromeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);

        player3EdgeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);


        player1ChromeDriver.findElement(By.id("btnReplaceJoker")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("meld0-tile2")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-6")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnAdd")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-4")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-5")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("meld2-tile0")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();

        wait(waitAfterCompletion);
        // valid
        Assertions.assertTrue(currentGame.getBoard().size() > 2);
        Assertions.assertTrue(player1.getInHand().size() < 9);

        player1ChromeDriver.close();
        player2ChromeDriver.close();
        player3EdgeDriver.close();
    }

    @Test
    public void row482() {
        gameService.resetGame();
        WebDriver player1ChromeDriver = webDriverLibrary.getChromeDriver();
        player1ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player1ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        Game currentGame = gameService.getCurrentGame();
        Player player1 = currentGame.getPlayerByNumber(1);

        gameService.placeInHand(player1, "R1 R2 R3 R4 R5 R6 R7 R8 R9 R10 R11 R12 B1 G1");

        WebDriver player2ChromeDriver = webDriverLibrary.getChromeDriver();
        player2ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player2ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnJoinGame")).click();
        Player player2 = currentGame.getPlayerByNumber(2);

        gameService.placeInHand(player2, "B1 B2 B3 B4 B5 B6 B7 B8 B9 B10 B11 O2 O3 O4");

        WebDriver player3EdgeDriver = webDriverLibrary.getEdgeDriver();
        player3EdgeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player3EdgeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player3EdgeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-1")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-2")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-3")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-4")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-5")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-6")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-7")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-8")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-9")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-10")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-11")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();
        wait(waitPerAction);

        player2ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("inHand-0")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("inHand-1")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("inHand-2")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("inHand-3")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("inHand-4")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("inHand-5")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("inHand-6")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("inHand-7")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("inHand-8")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("inHand-9")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("inHand-10")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnEndTurn")).click();
        wait(waitPerAction);

        player3EdgeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);


        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-0")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-1")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-2")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();

        wait(waitAfterCompletion);
        // valid
        Assertions.assertEquals(0, player1.getInHand().size());
        Assertions.assertEquals(0, player1.getScore());
        Assertions.assertEquals(-9, player2.getScore());

        player1ChromeDriver.close();
        player2ChromeDriver.close();
        player3EdgeDriver.close();
    }

    @Test
    public void row488() {
        gameService.resetGame();
        WebDriver player1ChromeDriver = webDriverLibrary.getChromeDriver();
        player1ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player1ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        Game currentGame = gameService.getCurrentGame();
        Player player1 = currentGame.getPlayerByNumber(1);

        gameService.placeInHand(player1, "R1 R2 R3 R4 R5 R6 R7 R8 R9 R10 R11 R12 B1 G1");

        WebDriver player2ChromeDriver = webDriverLibrary.getChromeDriver();
        player2ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player2ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnJoinGame")).click();
        Player player2 = currentGame.getPlayerByNumber(2);

        gameService.placeInHand(player2, "B1 B2 B3 B4 B5 B6 B7 B8 B9 B10 B11 O2 O3 *");

        WebDriver player3EdgeDriver = webDriverLibrary.getEdgeDriver();
        player3EdgeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player3EdgeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player3EdgeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-1")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-2")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-3")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-4")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-5")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-6")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-7")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-8")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-9")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-10")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-11")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();
        wait(waitPerAction);

        player2ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("inHand-0")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("inHand-1")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("inHand-2")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("inHand-3")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("inHand-4")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("inHand-5")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("inHand-6")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("inHand-7")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("inHand-8")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("inHand-9")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("inHand-10")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnEndTurn")).click();
        wait(waitPerAction);

        player3EdgeDriver.findElement(By.id("btnDraw")).click();
        wait(waitPerAction);


        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-0")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-1")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-2")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();

        wait(waitAfterCompletion);
        // valid
        Assertions.assertEquals(0, player1.getInHand().size());
        Assertions.assertEquals(0, player1.getScore());
        Assertions.assertEquals(-35, player2.getScore());

        player1ChromeDriver.close();
        player2ChromeDriver.close();
        player3EdgeDriver.close();
    }

    @Test
    public void row494() {
        gameService.resetGame();
        WebDriver player1ChromeDriver = webDriverLibrary.getChromeDriver();
        player1ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player1ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        Game currentGame = gameService.getCurrentGame();
        Player player1 = currentGame.getPlayerByNumber(1);

        gameService.placeInHand(player1, "R2 B2 G2 G3 G4 G5 G6 G7 O2 O4 O5 O6 O7 O8");

        WebDriver player2ChromeDriver = webDriverLibrary.getChromeDriver();
        player2ChromeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player2ChromeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player2ChromeDriver.findElement(By.id("btnJoinGame")).click();

        WebDriver player3EdgeDriver = webDriverLibrary.getEdgeDriver();
        player3EdgeDriver.manage().timeouts().implicitlyWait(implicitWaitDriver, TimeUnit.MILLISECONDS);
        player3EdgeDriver.get("http://localhost:4200/");
        wait(waitPerAction);
        player3EdgeDriver.findElement(By.id("btnJoinGame")).click();
        wait(waitPerAction);

        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-0")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-1")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-2")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-8")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-0")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-1")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-2")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-3")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-4")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnPlay")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-0")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-1")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-2")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-3")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("inHand-4")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnDone")).click();
        wait(waitPerAction);
        player1ChromeDriver.findElement(By.id("btnEndTurn")).click();

        wait(waitAfterCompletion);
        // valid
        Assertions.assertEquals(0, player1.getInHand().size());
        Assertions.assertEquals(0, player1.getScore());

        player1ChromeDriver.close();
        player2ChromeDriver.close();
        player3EdgeDriver.close();
    }

    public static void wait(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}
