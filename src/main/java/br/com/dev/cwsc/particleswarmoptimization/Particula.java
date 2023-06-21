package br.com.dev.cwsc.particleswarmoptimization;

public class Particula implements Cloneable
{
    private Coordenada coord_P = new Coordenada();
    private Coordenada vel_P = new Coordenada();
    private Coordenada pBest = new Coordenada();
    private boolean vazia;
    private double fitness;

    public Particula()
    {
        this.vazia = true;
    }

    public void setCoord_P(double x1, double x2, String x)
    {
        double auxFit, auxFit2;
        switch(x)
        {
            case "es":
                auxFit = Math.pow(x1, 2) + Math.pow(x2, 2);
                auxFit2 = Math.pow(this.pBest.get_x1(), 2) + Math.pow(this.pBest.get_x2(),2);
                this.atualizaPbest(auxFit, auxFit2, x1, x2);
                this.coord_P.setCoord(x1, x2);
                break;
            case "ro":
                auxFit = 100*Math.pow(x2-Math.pow(x1,2),2)+Math.pow(x1-1,2);
                auxFit2 = 100*Math.pow(this.pBest.get_x2()-Math.pow(this.pBest.get_x1(),2),2)+Math.pow(this.pBest.get_x1()-1,2);
                this.atualizaPbest(auxFit, auxFit2, x1, x2);
                this.coord_P.setCoord(x1, x2);
                break;
            case "ra":
                auxFit = 20+Math.pow(x1,2)-10*Math.cos(2*Math.PI*x1)
                        +Math.pow(x2,2)-10*Math.cos(2*Math.PI*x2);
                auxFit2 = 20+Math.pow(this.pBest.get_x1(),2)-10*Math.cos(2*Math.PI*this.pBest.get_x1())
                        +Math.pow(this.pBest.get_x2(),2)-10*Math.cos(2*Math.PI*this.pBest.get_x2());
                this.atualizaPbest(auxFit, auxFit2, x1, x2);
                this.coord_P.setCoord(x1, x2);
                break;
            default:
                System.out.println("String de ambiente inválida!");
                break;
        }
    }

    private void atualizaPbest(double auxFit, double auxFit2, double x1, double x2)
    {
        if (auxFit<auxFit2)
        {
            this.pBest.setCoord(x1, x2);
        }
    }

    public double getCoord_x1() {
        return this.coord_P.get_x1();
    }

    public double getCoord_x2() {
        return this.coord_P.get_x2();
    }

    public void setVel_P(double v1, double v2) {
        this.vel_P.setCoord(v1, v2);
    }

    public Coordenada getVel_P() {
        return this.vel_P;
    }

    public void setFitness(double fitness)
    {
        this.fitness = fitness;
    }

    public double getFitness()
    {
        return this.fitness;
    }

    public void setPbest(double x1, double x2) {
        this.pBest.setCoord(x1, x2);
    }

    public Coordenada getPbest() {
        return this.pBest;
    }

    public boolean getVazia()
    {
        return this.vazia;
    }

    public void setVazia(boolean x)
    {
        this.vazia = x;
    }
}
