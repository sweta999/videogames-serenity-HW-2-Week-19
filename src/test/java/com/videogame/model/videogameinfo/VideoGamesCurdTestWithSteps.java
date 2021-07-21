package com.videogame.model.videogameinfo;

import com.videogame.model.model.VideoGamePojo;
import com.videogame.model.testbase.TestBase;
import com.videogame.model.utils.TestUtils;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.annotations.Title;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.HashMap;

import static org.hamcrest.Matchers.hasValue;
import static org.junit.Assert.assertThat;

@RunWith(SerenityRunner.class)
public class VideoGamesCurdTestWithSteps extends TestBase {

    static int id = 12 + TestUtils.getRandomValueInInt();
    static String name = "Pacman2" + TestUtils.getRandomValue();
    static String releaseDate = "1982-08-20T11:08:09.573Z";
    static int reviewScore = 7;
    static String category = "Maze";
    static String rating = "Universal";
    static int videogameid;

    @Steps
    VideoGameSteps videoGameSteps;

    @Title("This will create a new video game")
    @Test
    public void test001() {

        HashMap<String, Object> value = videoGameSteps.createVideoGame(id, name, releaseDate, reviewScore, category, rating)
                .log().all()
                .statusCode(200).extract().response().body().jsonPath().get();
        System.out.println(value);
        assertThat(value, hasValue(name));
        videogameid = (int) value.get("id");
        System.out.println(videogameid);

    }

    @Title("Verify if the videogame was added to the application")
    @Test
    public void test002() {

        name = name + "_Updated";
        HashMap<String, Object> value = videoGameSteps.updateVideoGame(videogameid, id, name, releaseDate = "1985-08-20T11:08:09.573Z", reviewScore, category, rating)
                .statusCode(200).extract().response().body().jsonPath().get();

        assertThat(value,hasValue(name));
        System.out.println(value);

    }
}