package com.sg.dvdlibrarystreams.dto;

public class DVD {

    private String title;
    private String releaseDate;
    private String MPAARating;
    private String directorName;
    private String studio;
    private String userRating;

    public DVD(String title) {
        this.title = title;
    }
    
    public String getTitle() {
        return title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }
    
    public double getReleaseDateDouble() {
        double releaseDateDouble = 0;
        releaseDateDouble = Double.parseDouble(releaseDate);
        return releaseDateDouble;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public String getMPAARating() {
        return MPAARating;
    }

    public void setMPAARating(String MPAARating) {
        this.MPAARating = MPAARating;
    }

    public String getDirectorName() {
        return directorName;
    }

    public void setDirectorName(String directorName) {
        this.directorName = directorName;
    }
    
    public String getStudio() {
        return studio;
    }

    public void setStudio(String studio) {
        this.studio = studio;
    }
    
    public String getUserRating() {
        return userRating;
    }

    public void setUserRating(String userRating) {
        this.userRating = userRating;
    }
}
