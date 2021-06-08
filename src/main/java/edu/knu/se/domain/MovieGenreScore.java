package edu.knu.se.domain;


import javax.persistence.*;

@Entity
@SequenceGenerator(
		name = "FOR_MGS_SEQ",
		sequenceName = "seq_movie",
		initialValue = 1,
		allocationSize = 1
)
@Table(name = "mgs")
public class MovieGenreScore {
	@Id @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "FOR_MGS_SEQ")
	private Long Id;


	@Column
	private Long Userid;

	private Float Action;
	private Float Animation;
	private Float Adventure;



	private Float Children;
	private Float Comedy;
	private Float Crime;
	private Float Documentary;
	private Float Drama;
	private Float Fantasy;
	private Float FilmNoir;
	private Float Horror;
	private Float Musical;
	private Float Mystery;
	private Float Romance;
	private Float Scifi;
	private Float Thriller;
	private Float War;
	private Float Western;
	public MovieGenreScore() {
	}
	public void setAdventure(Float adventure) {
		Adventure = adventure;
	}

	public Float getAdventure() {
		return Adventure;
	}
	public void setId(Long id) {
		Id = id;
	}

	public void setUserid(Long userid) {
		Userid = userid;
	}

	public void setAction(Float action) {
		Action = action;
	}

	public void setAnimation(Float animation) {
		Animation = animation;
	}

	public void setChildren(Float children) {
		Children = children;
	}

	public void setComedy(Float comedy) {
		Comedy = comedy;
	}

	public void setCrime(Float crime) {
		Crime = crime;
	}

	public void setDocumentary(Float documentary) {
		Documentary = documentary;
	}

	public void setDrama(Float drama) {
		Drama = drama;
	}

	public void setFantasy(Float fantasy) {
		Fantasy = fantasy;
	}

	public void setFilmNoir(Float filmNoir) {
		FilmNoir = filmNoir;
	}

	public void setHorror(Float horror) {
		Horror = horror;
	}

	public void setMusical(Float musical) {
		Musical = musical;
	}

	public void setMystery(Float mystery) {
		Mystery = mystery;
	}

	public void setRomance(Float romance) {
		Romance = romance;
	}

	public void setScifi(Float scifi) {
		Scifi = scifi;
	}

	public void setThriller(Float thriller) {
		Thriller = thriller;
	}

	public void setWar(Float war) {
		War = war;
	}

	public void setWestern(Float western) {
		Western = western;
	}

	public Long getId() {
		return Id;
	}

	public Long getUserid() {
		return Userid;
	}

	public Float getAction() {
		return Action;
	}

	public Float getAnimation() {
		return Animation;
	}

	public Float getChildren() {
		return Children;
	}

	public Float getComedy() {
		return Comedy;
	}

	public Float getCrime() {
		return Crime;
	}

	public Float getDocumentary() {
		return Documentary;
	}

	public Float getDrama() {
		return Drama;
	}

	public Float getFantasy() {
		return Fantasy;
	}

	public Float getFilmNoir() {
		return FilmNoir;
	}

	public Float getHorror() {
		return Horror;
	}

	public Float getMusical() {
		return Musical;
	}

	public Float getMystery() {
		return Mystery;
	}

	public Float getRomance() {
		return Romance;
	}

	public Float getScifi() {
		return Scifi;
	}

	public Float getThriller() {
		return Thriller;
	}

	public Float getWar() {
		return War;
	}

	public Float getWestern() {
		return Western;
	}


}
