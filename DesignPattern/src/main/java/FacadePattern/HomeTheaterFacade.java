package FacadePattern;

public class HomeTheaterFacade {

  DvdPlayer dvdPlayer;
  CdPlayer cd;
  Projector projector;

  public HomeTheaterFacade(DvdPlayer dvdPlayer, CdPlayer cd, Projector projector) {
    this.dvdPlayer = dvdPlayer;
    this.cd = cd;
    this.projector = projector;
  }

  public String watchMovie(String movieName) {
    return dvdPlayer.on() + cd.on() + projector.on() + movieName;
  }


  public String endMovie() {
    return dvdPlayer.off() + cd.off() + projector.off();
  }
}
