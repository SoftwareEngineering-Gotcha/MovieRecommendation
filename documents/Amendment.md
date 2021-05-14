# [Amendment] 5.14
## Class Diagram

- Sequence Diagram title changed
	: Sequence Diagram title matched with Usecase Diagram
	
- State Diagram exception handled
	: State Diagram can't be straight, added exception handlings

# [Amendment] 5.5
## Class Diagram

- variable "id" in User case changed name to "uid" 

  : we have to use Spring API

- variable "name" in User case deleted and added variable "passwd" 

  : "name" is substituted to "uid" and we have to get "passwd" to use Spring API

- method getId() changed name to getUid() 

  : of unity between variable and method

- method getName() in User case deleted and added method getPasswd() 

  : User class doesn't have vairable "name" anymore and we added variable "passwd"

- method setUid() and setPasswd() added in User case 

  : we have to use Spring API

## User Class

- Password added in User Class

# [Amendment] 4.25
## Class diagram

- Add ArrayList<Integer> userGenreScore parameter to calculate() method in OverallCal Class.<br>
	: To get a genre score from user class<br>
	
- Add ArrayList<Integer> to return of askPreferenceWindow() method in UI Class<br>
	: To return a genre score to use calculate method<br>
	
- Add setMovieList() method to User Class<br>
	: To set movie list otherwise we cannot access movie list.
- Change type of genreId int to ArrayList<Integer><br>
	: Movie can have several genres.
- Change return type of getGenreId() method in Movie Class int to ArrayList<Integer>
	: Movie can have several genres.
- Change return type of calculate() and matching() method in OverallCal Class boolean to ArrayList<Integer><br>
	: To save MovieList variable’s data in User class.
- Remove Director ID and getDirectorId() method in Movie Class<br>
	: Director information is unnecessary for recommendation.
- Change parameter of provideMovieInfo() method of UI class void to ArrayList<Integer> useMovieList<br>
	: We need information to display
- Change all parameter type of matching() and calculate() method of OverallCal class List<Integer> to ArrayList<Integer><br>
	: We do not use class inherited List class except ArrayList class.
- Change return type of getGenreScore() method in MovieGenreScore class List<Integer> to ArrayList<Integer><br>
	: We do not use class inherited List class except ArrayList class.
# [Amendment] 4.12

## Class diagram

[COMMON] Add get method for each class

- User class’s method has changed.<br>

- Rename genreScore -> userGenreScore
- Remove matching -> replace OverallCal class
- Added OverallCal class.
- matching method : moved from user class 
- calculate method : call matching method
Requirements Document
- Removed recommendationInfo(), loadMovieInfo()
- Edited provideMovieInfo()

# #[Amendment] 4.7

## Class diagram

[COMMON] Add return type, factor entry for each method

- Add MovieScoreMatrix class<br>
- GenreScore -> RomanceScore, actionScore<br>
  : Change for ease of implementation<br>
- The MoiveScoreMatrix class has changed its relationship with Movie into an association:
- Delete genre class<br>: It is unnecessary because it can be included as a property value in the movie class.
- Use movie class -> movieScoreMatrix class to separate points for easy calculation.<br>
  Requirement documentation<br>
  uid : Spacing removed<br>
  User class :
- Change the return value of the askPerference method to boolean for ease of implementation
- Change the return value of the probideMovieInfo method to boolean for ease of implementation

