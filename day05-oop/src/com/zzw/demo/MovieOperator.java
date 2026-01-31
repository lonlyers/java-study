package com.zzw.demo;

public class MovieOperator {
    Movie[] movies;

    // 打印所有的电影信息,包括电影名称,导演,价格,编号
    public MovieOperator(Movie[] movies) {
        this.movies = movies;
    }

    public void printMovies() {
        for (int i = 0; i < movies.length; i++) {
            System.out.println(
                    "电影名称:" + movies[i].getName() +
                    ", 导演:" + movies[i].getDirector() +
                    ", 价格:" + movies[i].getPrice() +
                    ", 编号:" + movies[i].getId()
            );
        }
    }

    // 根据电影编号查找电影对象
    public void findMovieByCode(int code) {
        for (Movie movie : movies) {
            if (movie.getId() == code) {
                System.out.println(movie.getName());

            }else  {
                System.out.println("无此电影");
            }
        }

    }

}
