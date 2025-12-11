class Population {
    private long total;
    private String[] nationalities;

    public Population(long total, String[] nationalities) {
        this.total = total;
        this.nationalities = nationalities;
    }

    public long getTotal() {
        return total;
    }

    public String[] getNations() {
        return nationalities;
    }

    @Override
    public String toString() {
        return ", Total: " + total +
        ", Nationalities: " + String.join(", ", nationalities);
    }
}

class GDP {
    private double per_capita;
    private double per_capita_ppp;
    private double gni;

    public GDP(double per_capita, double per_capita_ppp, double gni) {
        this.per_capita = per_capita;
        this.per_capita_ppp = per_capita_ppp;
        this.gni = gni;
    }

    public double getPerCapita() {
        return per_capita;
    }

    public double getPerCapitaPPP() {
        return per_capita_ppp;
    }

    public double getGni() {
        return gni;
    }

    @Override
    public String toString() {
        return "Per Capita = " + per_capita +
        ", Per Capita PPP = " + per_capita_ppp +
        ", GNI = " + gni;
    }

}

class Country {
    private String name;
    private double area;
    private GDP gdp;
    private Population population;

    public Country(String name, double area, GDP gdp, Population population) {
        this.name = name;
        this.area = area;
        this.gdp = gdp;
        this.population = population;
    }

    public Country(String name, double area) {
        this.name = name;
        this.area = area;
    }

    public String getName() {
        return name;
    }

    public double getArea() {
        return area;
    }

    public GDP getGdp() {
        return gdp;
    }

    public Population getPopulation() {
        return population;
    }

    public double getDensity() {
        return population.getTotal() / area;
    }

    public void showInfo() {
        System.out.println("Country: " + name);
        System.out.println("Area: " + area);
        System.out.println("GDP: " + gdp);
        System.out.println("Population: " + population);
        System.out.println("Density: " + getDensity());
    }

}

public class Main {
    public static void main(String[] args) {
        String[] nationalities = {"Dzudzuni", "Makriki"};
        Population population = new Population(1200000, nationalities);
        GDP gdp = new GDP(14000, 11000, 25);
        Country country = new Country("Markistan", 50000, gdp, population);
        country.showInfo();
    }
}

