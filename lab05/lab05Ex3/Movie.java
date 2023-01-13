import java.util.*;

public class Movie {
   private final String title;
   private final int year;
   private final Person director;
   private final Person writer;
   private final String series;
   private final List<Person> cast;
   private final List<Place> locations;
   private final List<String> languages;
   private final List<String> genres;
   private final boolean isTelevision;
   private final boolean isNetflix;
   private final boolean isIndependent;
  // Inner builder pattern
   public static class Builder {
      // Required parameters
      private final String title;
      private final int year;
      private final Person director;
      private final Person writer;
      // Optional parameters
      private String series = "";
      private List<Person> cast = new List<Person>(){};
      private List<Place> locations = new List<Place>(); 
      private List<String> languages = new List<String>(); 
      private List<String> genres = new List<String>(); 
      private boolean isTelevision = false;
      private boolean isNetflix = false;
      private boolean isIndependent = false;
      // Contructor for Builder using Movie parameters
      public Builder(String title, int year, Person director, Person writer){
         this.title = title;
         this.year = year;
         this.director = director;
         this.writer = writer;
      }
      // Optionall parameters are processed separately
      public Builder series(String serie){
         series = serie;
         return this;
      }
      public Builder cast(List<Person> _cast_){
         cast.addAll(_cast_);
         return this;
      }
      public Builder locations(List<Place> location){
         locations.addAll(location);
         return this;
      }
      public Builder languages(List<String> lang){
         languages.addAll(lang);
         return this;
      }
      public Builder genres(List<String> genre){
         genres.addAll(genre);
         return this;
      }
      public Builder isTelevision(){
         isTelevision = true;
         return this;
      }
      public Builder isNetflix(){
         isNetflix = true;
         return this;
      }
      public Builder isIndependent(){
         isIndependent = true;
         return this;
      }
      // build() method to converts the class Builder to Movie 
      public Movie build() {
         return new Movie(this);
      }
   } // END OF CLASS BUILDER
   private Movie(Builder builder){ // Contructor for Movie using builder
      title = builder.title;
      year = builder.year;
      director = builder.director;
      writer = builder.writer;
      series = builder.series;
      cast = builder.cast;
      locations = builder.locations;
      languages = builder.languages;
      genres = builder.genres;
      isTelevision = builder.isTelevision;
      isNetflix = builder.isNetflix;
      isIndependent = builder.isIndependent;
   }
}

