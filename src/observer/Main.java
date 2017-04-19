/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observer;

import java.util.Random;

/**
 *
 * @author cuntycunt
 */
public class Main {    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random r = new Random();
        final int nParticipantes = 6;
        Leiloeiro leiloeiro = new Leiloeiro();
        Participante[] participantes = new Participante[nParticipantes];
        for(int i = 0; i<nParticipantes; i++){
            participantes[i] = new Participante(leiloeiro);
            leiloeiro.aceitarInscricao(participantes[i]);
        }
        leiloeiro.iniciarLeilao();
        for(int i = 0; i<nParticipantes; i++){
            Participante p = participantes[i];
            double lance = Math.round((r.nextDouble() + 1) * p.getPrecoAtual());
            p.fazerLance(lance);
        }
    }
    
}
