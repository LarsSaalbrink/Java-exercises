public class Termostat{
  private double heatingtemperature;
  private double coolingtemperature;

  public Termostat(){
    heatingtemperature = 15;
    coolingtemperature = 30;
  }

  public boolean timeToCool(double currentTemperature){
    return currentTemperature > coolingtemperature;
  }

  public boolean timeToHeat(double currentTemperature){
    return currentTemperature < heatingtemperature;
  }

  public void setTemperatures(double coolingtemperature, double heatingtemperature){
    this.coolingtemperature = coolingtemperature;
    this.heatingtemperature = heatingtemperature;
  }

  public double getTemperature(){
    return this.coolingtemperature;
  }
}