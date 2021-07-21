package com.videogame.model.videogameinfo;

import com.videogame.model.constants.EndPoints;
import com.videogame.model.model.VideoGamePojo;
import io.restassured.response.ValidatableResponse;
import net.serenitybdd.rest.SerenityRest;
import net.thucydides.core.annotations.Step;

import java.util.HashMap;

import static org.hamcrest.Matchers.hasValue;

public class VideoGameSteps {

    @Step("Creating videogame with id : {0}, name: {1}, releaseDate: {2}, reviewScore: {3}, category: (4} and rating: {5}")
    public ValidatableResponse createVideoGame(Integer id, String name, String releaseDate, Integer reviewScore,
                                               String category, String rating) {


        VideoGamePojo videoGamePojo = new VideoGamePojo();
        videoGamePojo.setId(id);
        videoGamePojo.setName(name);
        videoGamePojo.setReleaseDate(releaseDate);
        videoGamePojo.setReviewScore(reviewScore);
        videoGamePojo.setCategory(category);
        videoGamePojo.setRating(rating);


        return SerenityRest.rest().given().log().all()
                .header("Content-Type", "application/json")
                .body(videoGamePojo)
                .when()
                .post()
                .then();
    }

    @Step("Update videogame with videogameid: {0}, id : {1}, name: {2}, releaseDate: {3}, reviewScore: {4}, category: {5} and rating: {6}")
    public ValidatableResponse updateVideoGame(Integer videogame, Integer id, String name, String releaseDate, Integer reviewScore,
                                                         String category, String rating) {

        VideoGamePojo videoGamePojo = new VideoGamePojo();
        videoGamePojo.setId(id);
        videoGamePojo.setName(name);
        videoGamePojo.setReleaseDate(releaseDate);
        videoGamePojo.setReviewScore(reviewScore);
        videoGamePojo.setCategory(category);
        videoGamePojo.setRating(rating);

        return SerenityRest.rest().given().log().all()
                .header("Content-Type", "application/json")
                .body(videoGamePojo)
                .when()
                .put()
                .then();


    }

}
