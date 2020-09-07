/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DTO;

import entities.Movie;

/**
 *
 * @author marcg
 */
public class MovieDTO {

    private int year;
    private String title;
    private String[] actors;

    public MovieDTO(Movie m) {
        this.year = m.getYear();
        this.title = m.getTitle();
        this.actors = m.getActors();
    }
}
