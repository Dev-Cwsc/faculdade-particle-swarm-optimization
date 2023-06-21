package br.com.dev.cwsc.particleswarmoptimization;

import java.util.Random;

public class Enxame
{
    private Particula gBest = new Particula();
    private Particula enxame[];

    public void setGbest(Particula p, String x)
    {
        double x1, x2, fitness, v1, v2;
        x1 = p.getCoord_x1();
        x2 = p.getCoord_x2();
        fitness = p.getFitness();
        v1 = p.getVel_P().get_x1();
        v2 = p.getVel_P().get_x2();
        this.gBest.setCoord_P(x1, x2, x);
        this.gBest.setFitness(fitness);
        this.gBest.setVel_P(v1, v2);
    }

    public Particula getGbest()
    {
        return this.gBest;
    }

    public void atualizaGbest(String x)
    {
        if(this.gBest.getVazia()==true)
        {
            this.setGbest(this.enxame[0], x);
            for(int i=0; i<this.enxame.length; i++)
            {
                if(this.enxame[i].getFitness()<this.gBest.getFitness())
                {
                    this.setGbest(enxame[i], x);
                }
            }
            this.gBest.setVazia(false);
        }
        else
        {
            for(int i=0; i<this.enxame.length; i++)
            {
                if(this.gBest.getFitness()>enxame[i].getFitness())
                {
                    this.setGbest(enxame[i],x);
                }
            }
        }
    }

    public void atualizaVetGbest(Particula vet[], String x)
    {
        double x1, x2, fitness, v1, v2, p1, p2;
        x1 = this.gBest.getCoord_x1();
        x2 = this.gBest.getCoord_x2();
        fitness = this.gBest.getFitness();
        v1 = this.gBest.getVel_P().get_x1();
        v2 = this.gBest.getVel_P().get_x2();
        p1 = this.gBest.getPbest().get_x1();
        p2 = this.gBest.getPbest().get_x2();

        for(int i=0; i<vet.length; i++)
        {
            if(vet[i].getVazia() == true)
            {
                vet[i].setCoord_P(x1, x2, x);
                vet[i].setVel_P(v1, v2);
                vet[i].setPbest(p1, p2);
                vet[i].setFitness(fitness);
                vet[i].setVazia(false);
                break;
            }
        }
    }

    public void atualizaMGbest(double[] vetMedia, int nP)
    {
        double somaAux = 0.0;
        for(int i=0; i<this.enxame.length; i++)
        {
            somaAux += this.enxame[i].getFitness();
        }

        somaAux = (somaAux/nP);

        for(int i=0; i<vetMedia.length; i++)
        {
            if(vetMedia[i]==0.0)
            {
                vetMedia[i]=somaAux;
                break;
            }
        }
    }

    public Particula[] getEnxame()
    {
        return this.enxame;
    }

    public void inicializarEnxame(String x, int q)
    {
        this.enxame = new Particula[q];
        for(int i=0;i<this.enxame.length;i++)
        {
            this.enxame[i] = new Particula();
        }
        Random rand = new Random();
        int aux;
        for (int i=0;i<this.enxame.length;i++)
        {
            aux = rand.nextInt(21)+(-10);
            while(aux==0){aux = rand.nextInt(21)+(-10);}
            enxame[i].setCoord_P(rand.nextDouble()*aux, rand.nextDouble()*aux, x);
            enxame[i].setPbest(enxame[i].getCoord_x1(), enxame[i].getCoord_x2());
        }

        for (int i=0;i<this.enxame.length;i++)
        {
            aux = rand.nextInt(21)+(-10);
            enxame[i].setVel_P(rand.nextDouble()*aux, rand.nextDouble()*aux);
        }
    }

    public void atualizaVel_P(double c1, double c2, double w)
    {
        double v1, v2, nv1, nv2, px1, px2, gx1, gx2, ax1, ax2;
        Random rand = new Random();
        for (Particula enxame1 : this.enxame)
        {
            v1 = enxame1.getVel_P().get_x1();
            v2 = enxame1.getVel_P().get_x2();
            ax1 = enxame1.getCoord_x1();
            ax2 = enxame1.getCoord_x2();
            px1 = enxame1.getPbest().get_x1();
            px2 = enxame1.getPbest().get_x2();
            gx1 = this.gBest.getCoord_x1();
            gx2 = this.gBest.getCoord_x2();
            nv1 = w*v1+c1*1*(px1-ax1)+c2*1*(gx1-ax1);
            nv2 = w*v2+c1*1*(px2-ax2)+c2*1*(gx2-ax2);
            enxame1.setVel_P(nv1, nv2);
        }
    }

    public void reposicionar_P(String x)
    {
        for(int i=0;i<this.enxame.length;i++)
        {
            this.enxame[i].setCoord_P(this.enxame[i].getCoord_x1()+this.enxame[i].getVel_P().get_x1(),
                    this.enxame[i].getCoord_x2()+this.enxame[i].getVel_P().get_x2(), x);
        }
    }
}
