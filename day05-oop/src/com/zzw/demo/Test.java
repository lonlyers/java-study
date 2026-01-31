package com.zzw.demo;

public class Test {

    public static void main(String[] args) {
        Movie[] movies = new Movie[3];
        movies[0] = new Movie("肖申克的救赎", 9.9, "弗兰克·德拉邦特", 1001);
        movies[1] = new Movie("霸王别姬", 8.9, "陈凯歌", 1002);
        movies[2] = new Movie("阿甘正传", 9.5, "罗伯特·泽米吉斯", 1003);
        MovieOperator mo = new MovieOperator(
                movies
        );
        mo.printMovies();
        mo.findMovieByCode(1002);
    }
}
