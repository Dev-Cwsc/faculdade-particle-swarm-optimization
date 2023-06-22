package br.com.dev.cwsc.particleswarmoptimization;

import javax.swing.JOptionPane;
import java.awt.BorderLayout;

public class Main extends javax.swing.JFrame {

    private void iterar(String x, int nP, int iteracoes)
    {
        Ambiente a = new Ambiente();
        Enxame e = new Enxame();
        Particula[] vetGbest = new Particula[iteracoes];
        double[] vetMGbest = new double[iteracoes];

        pbr_progresso.setMaximum(iteracoes);

        for(int i=0; i<vetGbest.length; i++)
        {
            vetGbest[i] = new Particula();
        }

        e.inicializarEnxame(x,nP);

        for(int j=0; j<iteracoes ;j++)
        {
            a.calculaFitness(x, e);

            e.atualizaGbest(x);

            e.atualizaVetGbest(vetGbest, x);

            e.atualizaMGbest(vetMGbest, nP);

            e.atualizaVel_P(a.get_c1(), a.get_c2(), a.get_w());

            e.reposicionar_P(x);

            pbr_progresso.setValue(j+1);
        }
        e.atualizaGbest(x);

        atxt_resultados.setText("Dados da melhor partícula(Gbest):" + "\n"
                + "X1-> " + e.getGbest().getCoord_x1() + "\n"
                + "X2-> " + e.getGbest().getCoord_x2() + "\n"
                + "Fitness-> " + e.getGbest().getFitness());

        if(rbtn_gbest.isSelected())
        {
            this.pnl_grafico.setLayout(new BorderLayout());
            Graficos gLinha = new Graficos();
            this.pnl_grafico.add(gLinha.setPainel(vetGbest, "Gbest"));
            pack();
        }

        else if(rbtn_media.isSelected())
        {
            this.pnl_grafico.setLayout(new BorderLayout());
            Graficos gLinha = new Graficos();
            this.pnl_grafico.add(gLinha.setMediaPainel(vetMGbest, "Media"));
            pack();
        }
    }

    public Main() {
        initComponents();
    }

    private void initComponents() {
        jInternalFrame1 = new javax.swing.JInternalFrame();
        btng_terrenos = new javax.swing.ButtonGroup();
        btng_tipoGrafico = new javax.swing.ButtonGroup();
        pnl_principal = new javax.swing.JPanel();
        lbl_boasVindas = new javax.swing.JLabel();
        lbl_qtdParticulas = new javax.swing.JLabel();
        txt_qtdParticulas = new javax.swing.JTextField();
        lbl_selecTerreno = new javax.swing.JLabel();
        rbtn_esfera = new javax.swing.JRadioButton();
        rbtn_rosenbrock = new javax.swing.JRadioButton();
        rbtn_rastrigin = new javax.swing.JRadioButton();
        lbl_qtdIteracoes = new javax.swing.JLabel();
        txt_qtdIteracoes = new javax.swing.JTextField();
        btn_play = new javax.swing.JToggleButton();
        pbr_progresso = new javax.swing.JProgressBar();
        lbl_tipoGrafico = new javax.swing.JLabel();
        rbtn_gbest = new javax.swing.JRadioButton();
        rbtn_media = new javax.swing.JRadioButton();
        lbl_tipoGrafico2 = new javax.swing.JLabel();
        pnl_grafico = new javax.swing.JPanel();
        pnl_resultados = new javax.swing.JPanel();
        lbl_resultados = new javax.swing.JLabel();
        scr_resultados = new javax.swing.JScrollPane();
        atxt_resultados = new javax.swing.JTextArea();
        btn_sair = new javax.swing.JButton();
        btn_sobre = new javax.swing.JButton();

        jInternalFrame1.setVisible(true);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
                jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        jInternalFrame1Layout.setVerticalGroup(
                jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Trabalho Final - PSO");
        setResizable(false);

        pnl_principal.setAutoscrolls(true);

        lbl_boasVindas.setText("Bem vindo ao Particle Swarm Optimization :)");

        lbl_qtdParticulas.setText("Digite a quantidade de partículas:");

        lbl_selecTerreno.setText("Escolha o terreno:");

        btng_terrenos.add(rbtn_esfera);
        rbtn_esfera.setText("Esfera");
        rbtn_esfera.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtn_esferaActionPerformed(evt);
            }
        });

        btng_terrenos.add(rbtn_rosenbrock);
        rbtn_rosenbrock.setText("Rosenbrock");
        rbtn_rosenbrock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtn_rosenbrockActionPerformed(evt);
            }
        });

        btng_terrenos.add(rbtn_rastrigin);
        rbtn_rastrigin.setText("Rastrigin");
        rbtn_rastrigin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtn_rastriginActionPerformed(evt);
            }
        });

        lbl_qtdIteracoes.setText("Digite a quantidade de iterações:");

        btn_play.setText("Play!");
        btn_play.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_playActionPerformed(evt);
            }
        });

        lbl_tipoGrafico.setText("Selecione o tipo de gráfico que deseja exibir (se nenhuma das duas opções");

        btng_tipoGrafico.add(rbtn_gbest);
        rbtn_gbest.setText("Gráfico do Gbest em cada iteração");

        btng_tipoGrafico.add(rbtn_media);
        rbtn_media.setText("Média das fitness das partículas em cada iteração");
        rbtn_media.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rbtn_mediaActionPerformed(evt);
            }
        });

        lbl_tipoGrafico2.setText("for selecionada nenhum gráfico será exibido):");

        javax.swing.GroupLayout pnl_principalLayout = new javax.swing.GroupLayout(pnl_principal);
        pnl_principal.setLayout(pnl_principalLayout);
        pnl_principalLayout.setHorizontalGroup(
                pnl_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnl_principalLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(pnl_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(pnl_principalLayout.createSequentialGroup()
                                                .addGroup(pnl_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(pnl_principalLayout.createSequentialGroup()
                                                                .addGroup(pnl_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(lbl_qtdIteracoes)
                                                                        .addComponent(rbtn_rastrigin))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(txt_qtdIteracoes, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(lbl_tipoGrafico)
                                                        .addComponent(lbl_selecTerreno)
                                                        .addComponent(rbtn_rosenbrock)
                                                        .addComponent(rbtn_esfera)
                                                        .addComponent(rbtn_gbest)
                                                        .addComponent(rbtn_media)
                                                        .addComponent(lbl_tipoGrafico2))
                                                .addGap(0, 0, Short.MAX_VALUE))
                                        .addGroup(pnl_principalLayout.createSequentialGroup()
                                                .addGroup(pnl_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(pnl_principalLayout.createSequentialGroup()
                                                                .addComponent(btn_play)
                                                                .addGap(38, 38, 38)
                                                                .addComponent(pbr_progresso, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                        .addComponent(lbl_boasVindas)
                                                        .addGroup(pnl_principalLayout.createSequentialGroup()
                                                                .addComponent(lbl_qtdParticulas)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(txt_qtdParticulas, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addContainerGap(76, Short.MAX_VALUE))))
        );
        pnl_principalLayout.setVerticalGroup(
                pnl_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnl_principalLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(lbl_boasVindas)
                                .addGap(14, 14, 14)
                                .addGroup(pnl_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lbl_qtdParticulas)
                                        .addComponent(txt_qtdParticulas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(21, 21, 21)
                                .addGroup(pnl_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(lbl_qtdIteracoes)
                                        .addComponent(txt_qtdIteracoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(35, 35, 35)
                                .addComponent(lbl_selecTerreno)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rbtn_esfera)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rbtn_rosenbrock)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rbtn_rastrigin)
                                .addGap(35, 35, 35)
                                .addComponent(lbl_tipoGrafico, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(5, 5, 5)
                                .addComponent(lbl_tipoGrafico2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rbtn_gbest)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(rbtn_media)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 112, Short.MAX_VALUE)
                                .addGroup(pnl_principalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(pbr_progresso, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(btn_play, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addContainerGap())
        );

        javax.swing.GroupLayout pnl_graficoLayout = new javax.swing.GroupLayout(pnl_grafico);
        pnl_grafico.setLayout(pnl_graficoLayout);
        pnl_graficoLayout.setHorizontalGroup(
                pnl_graficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );
        pnl_graficoLayout.setVerticalGroup(
                pnl_graficoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGap(0, 0, Short.MAX_VALUE)
        );

        lbl_resultados.setText("Resultados:");

        atxt_resultados.setColumns(20);
        atxt_resultados.setRows(5);
        scr_resultados.setViewportView(atxt_resultados);

        btn_sair.setText("Sair");
        btn_sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sairActionPerformed(evt);
            }
        });

        btn_sobre.setText("Sobre");
        btn_sobre.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_sobreActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnl_resultadosLayout = new javax.swing.GroupLayout(pnl_resultados);
        pnl_resultados.setLayout(pnl_resultadosLayout);
        pnl_resultadosLayout.setHorizontalGroup(
                pnl_resultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnl_resultadosLayout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(pnl_resultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnl_resultadosLayout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addGroup(pnl_resultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(btn_sair, javax.swing.GroupLayout.Alignment.TRAILING)
                                                        .addComponent(btn_sobre, javax.swing.GroupLayout.Alignment.TRAILING)))
                                        .addGroup(pnl_resultadosLayout.createSequentialGroup()
                                                .addGroup(pnl_resultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(scr_resultados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(lbl_resultados))
                                                .addGap(0, 314, Short.MAX_VALUE)))
                                .addContainerGap())
        );
        pnl_resultadosLayout.setVerticalGroup(
                pnl_resultadosLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(pnl_resultadosLayout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lbl_resultados)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(scr_resultados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(20, 20, 20)
                                .addComponent(btn_sobre)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btn_sair)
                                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addComponent(pnl_principal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(pnl_resultados, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(pnl_grafico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(pnl_principal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(pnl_grafico, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(pnl_resultados, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }

    private void rbtn_rosenbrockActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    private void rbtn_esferaActionPerformed(java.awt.event.ActionEvent evt) {
    }

    private void btn_sairActionPerformed(java.awt.event.ActionEvent evt) {
        System.exit(0);
    }

    private void btn_playActionPerformed(java.awt.event.ActionEvent evt) {
        try
        {
            if(rbtn_esfera.isSelected() && txt_qtdParticulas.getText() != "" && txt_qtdIteracoes.getText() != "")
            {
                iterar("es",Integer.parseInt(txt_qtdParticulas.getText()), Integer.parseInt(txt_qtdIteracoes.getText()));
                JOptionPane.showMessageDialog(null,"Iterações finalizadas com sucesso!");
                pbr_progresso.setValue(0);
            }
            else if(rbtn_rosenbrock.isSelected() && txt_qtdParticulas.getText() != "" && txt_qtdIteracoes.getText() != "")
            {
                iterar("ro",Integer.parseInt(txt_qtdParticulas.getText()), Integer.parseInt(txt_qtdIteracoes.getText()));
                JOptionPane.showMessageDialog(null,"Iterações finalizadas com sucesso!");
                pbr_progresso.setValue(0);
            }
            else if(rbtn_rastrigin.isSelected() && txt_qtdParticulas.getText() != "" && txt_qtdIteracoes.getText() != "")
            {
                iterar("ra",Integer.parseInt(txt_qtdParticulas.getText()), Integer.parseInt(txt_qtdIteracoes.getText()));
                JOptionPane.showMessageDialog(null,"Iterações finalizadas com sucesso!");
                pbr_progresso.setValue(0);
            }else
            {
                JOptionPane.showMessageDialog(null,"Selecione uma opção de terreno!");
            }
        }catch(NumberFormatException e)
        {
            JOptionPane.showMessageDialog(null,"Dados de entrada inválidos. Preencha os campos digitando apenas números inteiros positivos.");
        }
    }

    private void rbtn_rastriginActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void rbtn_mediaActionPerformed(java.awt.event.ActionEvent evt) {

    }

    private void btn_sobreActionPerformed(java.awt.event.ActionEvent evt) {
        JOptionPane.showMessageDialog(null," Otimização por Enxame de Partículas (Particle Swarm Optimization) \n "
                + "Desenvolvido por: Carlos Willian Silva Camargos && Vitor Daniel Leal"
                + "\n Professor: Ciniro Nametala \n Disciplina: Programação Orientada a Objetos.");
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    private javax.swing.JTextArea atxt_resultados;
    private javax.swing.JToggleButton btn_play;
    private javax.swing.JButton btn_sair;
    private javax.swing.JButton btn_sobre;
    private javax.swing.ButtonGroup btng_terrenos;
    private javax.swing.ButtonGroup btng_tipoGrafico;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel lbl_boasVindas;
    private javax.swing.JLabel lbl_qtdIteracoes;
    private javax.swing.JLabel lbl_qtdParticulas;
    private javax.swing.JLabel lbl_resultados;
    private javax.swing.JLabel lbl_selecTerreno;
    private javax.swing.JLabel lbl_tipoGrafico;
    private javax.swing.JLabel lbl_tipoGrafico2;
    private javax.swing.JProgressBar pbr_progresso;
    private javax.swing.JPanel pnl_grafico;
    private javax.swing.JPanel pnl_principal;
    private javax.swing.JPanel pnl_resultados;
    private javax.swing.JRadioButton rbtn_esfera;
    private javax.swing.JRadioButton rbtn_gbest;
    private javax.swing.JRadioButton rbtn_media;
    private javax.swing.JRadioButton rbtn_rastrigin;
    private javax.swing.JRadioButton rbtn_rosenbrock;
    private javax.swing.JScrollPane scr_resultados;
    private javax.swing.JTextField txt_qtdIteracoes;
    private javax.swing.JTextField txt_qtdParticulas;
}