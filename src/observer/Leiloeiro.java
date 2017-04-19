/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observer;

import java.util.ArrayList;

/**
 *
 * @author cuntycunt
 */
public class Leiloeiro implements Subject {

    private final ArrayList<Participante> participantes;    
    private double precoAtual;  //idealmente esse atributo nao ficaria aki, mas eh soh para fins de didatica
    private boolean leilaoIniciado;
    private Participante ultimoParticipanteLance; //idem para esse atributo

    public Leiloeiro() {
        this.participantes = new ArrayList<>();
        this.precoAtual = 10;
        this.leilaoIniciado = false;
    }

    public void iniciarLeilao() {
        if (!leilaoIniciado) {
            System.out.println("O leilão está começando! O lance mínimo é de R$" + this.precoAtual + "\n");
        }
        this.leilaoIniciado = true;
        //notifica inscritos sobre o preco do primeiro lance
        notificarInscritos();
    }

    public void aceitarLance(Lance lance) {
        if (lance.getPreco() > this.precoAtual) {
            this.precoAtual = lance.getPreco();
            System.out.println("\nLance dado pelo participante n. " + lance.getParticipante().getId()
                    + " no valor de R$" + this.precoAtual + "\n");
            this.ultimoParticipanteLance = lance.getParticipante();
            notificarInscritos(lance);
        }
        //deveria jogar uma excecao aki, mas como eh soh para fins de exemplo, fica assim msm 
    }

    @Override
    public void notificarInscritos(Object mensagem) {
        participantes.forEach((o) -> {
            //o participante q ocasionou a alteracao nao precisa ser alertado redundantemente sobre ela
            //essa verificacao poderia ser feita com mto mais elegancia, mas para fins de didatica, assim tah bom
            if(o != this.ultimoParticipanteLance){
                o.receberNotificacao(mensagem);
            }            
        });
    }

    @Override
    public void aceitarInscricao(Observer obs) {
        Participante participante = (Participante) obs;
        this.participantes.add(participante);
    }

    @Override
    public void notificarInscritos() {
        participantes.forEach((o) -> {
            if(o != this.ultimoParticipanteLance){
                o.receberNotificacao(this.precoAtual);
            }            
        });
    }
}
