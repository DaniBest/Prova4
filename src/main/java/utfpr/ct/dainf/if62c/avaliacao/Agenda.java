package utfpr.ct.dainf.if62c.avaliacao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Timer;

/**
 * IF62C Fundamentos de Programação 2 Avaliação parcial.
 *
 * @author Daniel
 */
public class Agenda {

    private final String descricao;
    private final List<Compromisso> compromissos = new ArrayList<>();
    private final Timer timer;

    public Agenda(String descricao) {
        this.descricao = descricao;
        timer = new Timer(descricao);
    }

    public String getDescricao() {
        return descricao;
    }

    public List<Compromisso> getCompromissos() {
        return compromissos;
    }

    public Timer getTimer() {
        return timer;
    }

    public void novoCompromisso(Compromisso compromisso) {
        compromissos.add(compromisso);
        Aviso aviso = new AvisoFinal(compromisso);
        compromisso.registraAviso(aviso);
        // com a classe Aviso devidamente implementada, o erro de compilação
        // deverá desaparecer
        timer.schedule(aviso, compromisso.getData());
    }

    public void novoAviso(Compromisso compromisso, int antecedencia) {

        Aviso aviso = new Aviso(compromisso);
        compromisso.registraAviso(aviso);
        Date adiantamento = new Date(compromisso.getData().getTime() - (antecedencia * 1000));
        timer.schedule(aviso, adiantamento);

    }

    public void novoAviso(Compromisso compromisso, int antecedencia, int intervalo) {

        antecedencia = antecedencia * 1000;
        long intervaloReal = (long) intervalo * 1000;

        Aviso aviso = new Aviso(compromisso);
        compromisso.registraAviso(aviso);
        Date adiantamento = new Date(compromisso.getData().getTime() - (antecedencia * 1000));
        timer.schedule(aviso, adiantamento, intervaloReal);

    }

    public void cancela(Compromisso compromisso) {
        for (Aviso aviso : compromisso.getAvisos()) {
//            cancela(aviso);
            aviso.cancel();
        }
        compromisso.getAvisos().clear();
        getCompromissos().remove(compromisso);
    }

    public void cancela(Aviso aviso) {
        aviso.cancel();
        aviso.getCompromisso().getAvisos().remove(aviso);
    }

    public void destroi() {
        for (Compromisso compromisso : getCompromissos()) {
            for (Aviso aviso : compromisso.getAvisos()) {
//            cancela(aviso);
                aviso.cancel();
            }
            compromisso.getAvisos().clear();
        }
        getCompromissos().clear();
        getTimer().cancel();
    }
}
