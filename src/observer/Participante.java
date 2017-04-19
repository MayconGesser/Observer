/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package observer;

/**
 *
 * @author cuntycunt
 */
public class Participante extends Observer {

    private static int ids = 0;
    private final int id;
    private final Leiloeiro leiloeiro;
    private Double precoAtual;

    public Participante(Leiloeiro leiloeiro) {
        this.leiloeiro = leiloeiro;
        this.id = ++ids;
    }

    @Override
    public void receberNotificacao(Object mensagem) {
        if (mensagem instanceof Lance) {
            Lance lanceRecebido = (Lance) mensagem;
            this.precoAtual = lanceRecebido.getPreco();
            System.out.println(confirmacaoMensagem());
        } else {
            this.precoAtual = (double) mensagem;
            System.out.println(confirmacaoMensagem());
        }
    }

    public int getId() {
        return id;
    }

    public void fazerLance(Double lance) {
        Lance lanceDado = new Lance(this, lance);
        leiloeiro.aceitarLance(lanceDado);
    }

    public Double getPrecoAtual() {
        return precoAtual;
    }

    private String confirmacaoMensagem() {
        return "Participante n. " + this.id + " recebeu a mensagem: "
                + "O preço atual do leilão é R$" + this.precoAtual;
    }
}
