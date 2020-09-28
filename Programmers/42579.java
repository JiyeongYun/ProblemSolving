import java.util.*;

class Song implements Comparable<Song>{
    private int index;              //노래 고유번호
    private int playCount;          //재생된 횟수

    Song(int index, int playCount) {
        this.index = index;
        this.playCount = playCount;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    int getPlayCount() {
        return playCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Song song = (Song) o;

        return index == song.index;
    }

    @Override
    public int compareTo(Song o) {
        return o.playCount - this.playCount;
    }
}

class Genre implements Comparable<Genre>{
    private String name;
    private List<Song> songs;
    private int totalCount;

    Genre(String name) {
        this.name = name;
        songs = new LinkedList<>();
        this.totalCount = 0;
    }

    void addSong(Song song) {
        songs.add(song);
    }

    void sortSongs() {
        Collections.sort(songs);
    }

    void calcTotalCount() {
        for (Song song : songs) {
            totalCount += song.getPlayCount();
        }
    }

    Song getSong(int index) {
        return songs.get(index);
    }

    @Override
    public int compareTo(Genre o) {
        return o.totalCount - this.totalCount;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Genre genre = (Genre) o;

        return name != null ? name.equals(genre.name) : genre.name == null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Song> getSongs() {
        return songs;
    }
}

class Solution {
    public int[] solution(String[] genres, int[] plays) {
        List<Genre> genreList = setGenresAndSongs(genres, plays);

        for (Genre genre : genreList) {
            genre.sortSongs();
            genre.calcTotalCount();
        }
        Collections.sort(genreList);

        List<Integer> answerList = new ArrayList<>();
        for (Genre genre : genreList) {
            answerList.add(genre.getSong(0).getIndex());
            if (genre.getSongs().size() > 1) {
                answerList.add(genre.getSong(1).getIndex());
            }
        }

        int[] answer = new int[answerList.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = answerList.get(i);
        }
        return answer;
    }

    private List<Genre> setGenresAndSongs(String[] genres, int[] plays) {
        List<Genre> genreList = new ArrayList<>();
        for (int i = 0; i<genres.length; i++) {
            Genre genre1 = new Genre(genres[i]);
            if (!genreList.contains(genre1)) {
                genreList.add(genre1);
            }
            for (Genre genre : genreList) {
                if (genre.getName().equals(genres[i])) {
                    genre.addSong(new Song(i, plays[i]));
                }
            }
        }
        return genreList;
    }
}
