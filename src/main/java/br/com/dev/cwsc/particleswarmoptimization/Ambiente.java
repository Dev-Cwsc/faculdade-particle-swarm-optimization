package br.com.dev.cwsc.particleswarmoptimization;

public class Ambiente
{
    private final double c1 = 1;
    private final double c2 = 2;
    private final double w = 0.5;

    public double f_Esfera(double x1, double x2)
    {
        double auxFit = Math.pow(x1, 2) + Math.pow(x2, 2);
        return auxFit;
    }

    public double f_Rosenbrock(double x1, double x2)
    {
        double auxFit = 100*Math.pow(x2-Math.pow(x1,2),2)+Math.pow(x1-1,2);
        return auxFit;
    }

    public double f_Rastrigin(double x1, double x2)
    {
        double auxFit = 20 + Math.pow(x1, 2) - 10*Math.cos(2*Math.PI*x1)
                + Math.pow(x2, 2) - 10*Math.cos(2*Math.PI*x2);
        return auxFit;
    }

    public void calculaFitness(String x, Enxame e)
    {
        switch(x)
        {
            case "es":
                for(int i=0; i<e.getEnxame().length; i++)
                {
                    e.getEnxame()[i].setFitness(this.f_Esfera(e.getEnxame()[i].getCoord_x1(), e.getEnxame()[i].getCoord_x2()));
                }
                break;
            case "ro":
                for(int i=0; i<e.getEnxame().length; i++)
                {
                    e.getEnxame()[i].setFitness(this.f_Rosenbrock(e.getEnxame()[i].getCoord_x1(), e.getEnxame()[i].getCoord_x2()));
                }
                break;
            case "ra":
                for(int i=0; i<e.getEnxame().length; i++)
                {
                    e.getEnxame()[i].setFitness(this.f_Rastrigin(e.getEnxame()[i].getCoord_x1(), e.getEnxame()[i].getCoord_x2()));
                }
                break;
            default:
                System.out.println("Erro");
                break;
        }
    }

    public double get_c1()
    {
        return this.c1;
    }

    public double get_c2()
    {
        return this.c2;
    }

    public double get_w()
    {
        return this.w;
    }
}
