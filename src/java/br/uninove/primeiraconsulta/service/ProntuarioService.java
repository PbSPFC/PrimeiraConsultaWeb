/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.uninove.primeiraconsulta.service;

import br.uninove.primeiraconsulta.dao.AnamneseDao;
import br.uninove.primeiraconsulta.dao.EstiloDeVidaDao;
import br.uninove.primeiraconsulta.dao.ExameFisicoDao;
import br.uninove.primeiraconsulta.dao.ListaProblemasDao;
import br.uninove.primeiraconsulta.dao.ProntuarioDao;
import br.uninove.primeiraconsulta.dao.log.LogAnamneseDao;
import br.uninove.primeiraconsulta.dao.log.LogEstiloDeVidaDao;
import br.uninove.primeiraconsulta.dao.log.LogExameFisicoDao;
import br.uninove.primeiraconsulta.dao.log.LogListaProblemasDao;
import br.uninove.primeiraconsulta.dao.log.LogProntuarioDao;
import br.uninove.primeiraconsulta.entidade.Anamnese;
import br.uninove.primeiraconsulta.entidade.EstiloDeVida;
import br.uninove.primeiraconsulta.entidade.ExameFisico;
import br.uninove.primeiraconsulta.entidade.ListaProblemas;
import br.uninove.primeiraconsulta.entidade.Prontuario;
import br.uninove.primeiraconsulta.entidade.Usuario;
import br.uninove.primeiraconsulta.entidade.log.LogAnamnese;
import br.uninove.primeiraconsulta.entidade.log.LogEstiloDeVida;
import br.uninove.primeiraconsulta.entidade.log.LogExameFisico;
import br.uninove.primeiraconsulta.entidade.log.LogListaProblemas;
import br.uninove.primeiraconsulta.entidade.log.LogProntuario;
import br.uninove.primeiraconsulta.util.DataUtil;
import java.util.List;

/**
 *
 * @author PB
 */
public class ProntuarioService {

    private ProntuarioDao prontuarioDao;
    private AnamneseDao anamneseDao;
    private EstiloDeVidaDao estiloDeVidaDao;
    private ExameFisicoDao exameFisicoDao;
    private ListaProblemasDao listaProblemasDao;

    private LogProntuarioDao logProntuarioDao;
    private LogAnamneseDao logAnamneseDao;
    private LogEstiloDeVidaDao logEstiloDeVidaDao;
    private LogExameFisicoDao logExameFisicoDao;
    private LogListaProblemasDao logListaProblemasDao;

    public ProntuarioService(ProntuarioDao prontuarioDao, AnamneseDao anamneseDao, EstiloDeVidaDao estiloDeVidaDao,
            ExameFisicoDao exameFisicoDao, ListaProblemasDao listaProblemasDao,
            LogProntuarioDao logProntuarioDao, LogAnamneseDao logAnamneseDao, LogEstiloDeVidaDao logEstiloDeVidaDao,
            LogExameFisicoDao logExameFisicoDao, LogListaProblemasDao logListaProblemasDao) {
        this.prontuarioDao = prontuarioDao;
        this.anamneseDao = anamneseDao;
        this.estiloDeVidaDao = estiloDeVidaDao;
        this.exameFisicoDao = exameFisicoDao;
        this.listaProblemasDao = listaProblemasDao;
        this.logProntuarioDao = logProntuarioDao;
        this.logAnamneseDao = logAnamneseDao;
        this.logEstiloDeVidaDao = logEstiloDeVidaDao;
        this.logExameFisicoDao = logExameFisicoDao;
        this.logListaProblemasDao = logListaProblemasDao;
    }

    public void cadastrar(Prontuario prontuario, Anamnese anamnese, Usuario usuario, EstiloDeVida estiloDeVida, ExameFisico exameFisico, List<ListaProblemas> listaProblemas) throws RegraNegocioException {
        try {
            if (numProntuarioJaExiste(prontuario)) {
                throw new RegraNegocioException("Número de prontuário já está cadastrado!");
            }

            EstiloDeVidaService estiloDeVidaService = new EstiloDeVidaService(estiloDeVidaDao);
            ExameFisicoService exameFisicoService = new ExameFisicoService(exameFisicoDao);

            String data = DataUtil.getDate();

            prontuario.setData(data);
            prontuario.setDataEdicao(data);
            estiloDeVida.setDataEdicao(data);
            exameFisico.setDataEdicao(data);
            anamnese.setDataEdicao(data);

            for (ListaProblemas listaProblema : listaProblemas) {
                listaProblema.setNumProntuario(prontuario.getNumProntuario());
                listaProblema.setDataEdicao(data);
                listaProblemasDao.salvar(listaProblema);
            }

            prontuario.setIdUsuario(usuario.getId());
            prontuario.setRaUsuario(usuario.getRa());
            prontuario.setNomeMedico(usuario.getNome());

            anamnese.setNumProntuario(prontuario.getNumProntuario());
            anamnese = this.anamneseDao.salvar(anamnese);

            estiloDeVida.setNumProntuario(prontuario.getNumProntuario());
            estiloDeVida = estiloDeVidaService.salvar(estiloDeVida);

            exameFisico.setNumProntuario(prontuario.getNumProntuario());
            exameFisico = exameFisicoService.salvar(exameFisico, prontuario);

            prontuario.setIdAnamnese(anamnese.getId());
            prontuario.setIdEstiloDeVida(estiloDeVida.getId());
            prontuario.setIdExameFisico(exameFisico.getId());

            prontuario = this.prontuarioDao.salvar(prontuario);
            
            //Log
            
            for (ListaProblemas listaProblema : listaProblemas) {
                listaProblema.setId(null);
                LogListaProblemas logListaProblemas = new LogListaProblemas(listaProblema);
                logListaProblemasDao.salvar(logListaProblemas);
            }
            
            prontuario.setId(null);
            LogProntuario logProntuario = new LogProntuario(prontuario);
            logProntuarioDao.salvar(logProntuario);
            
            anamnese.setId(null);
            LogAnamnese logAnamnese = new LogAnamnese(anamnese);
            logAnamneseDao.salvar(logAnamnese);
            
            estiloDeVida.setId(null);
            LogEstiloDeVida logEstiloDeVida = new LogEstiloDeVida(estiloDeVida);
            logEstiloDeVidaDao.salvar(logEstiloDeVida);
            
            exameFisico.setId(null);
            LogExameFisico logExameFisico = new LogExameFisico(exameFisico);
            logExameFisicoDao.salvar(logExameFisico);
            
            
        } catch (Exception e) {
            throw new RegraNegocioException("Ocorreu um erro! " + e.getMessage());
        }
    }

    public void salvar(Prontuario prontuario, Anamnese anamnese, EstiloDeVida estiloDeVida, ExameFisico exameFisico, List<ListaProblemas> listaProblemas) throws RegraNegocioException {

        try {

            EstiloDeVidaService estiloDeVidaService = new EstiloDeVidaService(estiloDeVidaDao);
            ExameFisicoService exameFisicoService = new ExameFisicoService(exameFisicoDao);

            String data = DataUtil.getDate();

            prontuario.setDataEdicao(data);
            estiloDeVida.setDataEdicao(data);
            exameFisico.setDataEdicao(data);
            anamnese.setDataEdicao(data);

            List<ListaProblemas> listaProblemasAntiga = listaProblemasDao.porNumProntuario(prontuario.getNumProntuario());

            for (ListaProblemas listaProblema : listaProblemasAntiga) {
                this.listaProblemasDao.deletar(listaProblema);
            }
            for (ListaProblemas listaProblema : listaProblemas) {
                listaProblema.setNumProntuario(prontuario.getNumProntuario());
                listaProblema.setDataEdicao(data);
                listaProblemasDao.salvar(listaProblema);
            }

            this.anamneseDao.salvar(anamnese);
            estiloDeVidaService.salvar(estiloDeVida);
            exameFisicoService.salvar(exameFisico, prontuario);
            this.prontuarioDao.salvar(prontuario);
            
            //Log
            
            for (ListaProblemas listaProblema : listaProblemas) {
                listaProblema.setId(null);
                LogListaProblemas logListaProblemas = new LogListaProblemas(listaProblema);
                logListaProblemasDao.salvar(logListaProblemas);
            }
            
            prontuario.setId(null);
            LogProntuario logProntuario = new LogProntuario(prontuario);
            logProntuarioDao.salvar(logProntuario);
            
            anamnese.setId(null);
            LogAnamnese logAnamnese = new LogAnamnese(anamnese);
            logAnamneseDao.salvar(logAnamnese);
            
            estiloDeVida.setId(null);
            LogEstiloDeVida logEstiloDeVida = new LogEstiloDeVida(estiloDeVida);
            logEstiloDeVidaDao.salvar(logEstiloDeVida);
            
            exameFisico.setId(null);
            LogExameFisico logExameFisico = new LogExameFisico(exameFisico);
            logExameFisicoDao.salvar(logExameFisico);
            
        } catch (Exception e) {
            throw new RegraNegocioException("Ocorreu um erro!");
        }
    }

    private boolean numProntuarioJaExiste(Prontuario prontuario) {
        Prontuario prontuarioExistente = this.prontuarioDao.porNumProntuario(prontuario.getNumProntuario());

        return prontuarioExistente != null && !prontuarioExistente.equals(prontuario);
    }

    public void excluir(Prontuario prontuario) throws RegraNegocioException {
        Anamnese anamnese = anamneseDao.porId(prontuario.getIdAnamnese());
        EstiloDeVida estiloDeVida = estiloDeVidaDao.porId(prontuario.getIdEstiloDeVida());
        ExameFisico exameFisico = exameFisicoDao.porId(prontuario.getIdExameFisico());
        List<ListaProblemas> listaProblemas = listaProblemasDao.porNumProntuario(prontuario.getNumProntuario());
        
        List<LogProntuario> logProntuarios = logProntuarioDao.todasPorNumProntuario(prontuario.getNumProntuario());
        List<LogAnamnese> logAnamneses = logAnamneseDao.todasPorNumProntuario(prontuario.getNumProntuario());
        List<LogEstiloDeVida> logEstiloDeVidas = logEstiloDeVidaDao.todasPorNumProntuario(prontuario.getNumProntuario());
        List<LogExameFisico> logExameFisicos = logExameFisicoDao.todasPorNumProntuario(prontuario.getNumProntuario());
        List<LogListaProblemas> logListaProblemases = logListaProblemasDao.todasPorNumProntuario(prontuario.getNumProntuario());

        for (ListaProblemas listaProblema : listaProblemas) {
            this.listaProblemasDao.deletar(listaProblema);
        }

        this.anamneseDao.deletar(anamnese);
        this.estiloDeVidaDao.deletar(estiloDeVida);
        this.exameFisicoDao.deletar(exameFisico);
        this.prontuarioDao.deletar(prontuario);
        
        for (LogListaProblemas logListaProblemase : logListaProblemases) {
            this.logListaProblemasDao.deletar(logListaProblemase);
        }
        for (LogExameFisico logExameFisico : logExameFisicos) {
            this.logExameFisicoDao.deletar(logExameFisico);
        }
        for (LogEstiloDeVida logEstiloDeVida : logEstiloDeVidas) {
            this.logEstiloDeVidaDao.deletar(logEstiloDeVida);
        }
        for (LogAnamnese logAnamnese : logAnamneses) {
            this.logAnamneseDao.deletar(logAnamnese);
        }
        for (LogProntuario logProntuario : logProntuarios) {
            this.logProntuarioDao.deletar(logProntuario);
        }
        
    }

    public void excluirLog(LogProntuario logProntuario) throws RegraNegocioException{
        LogAnamnese logAnamnese = logAnamneseDao.porNumProntuarioEData(logProntuario.getNumProntuario(), logProntuario.getDataEdicao());
        LogEstiloDeVida logEstiloDeVida = logEstiloDeVidaDao.porNumProntuarioEData(logProntuario.getNumProntuario(), logProntuario.getDataEdicao());
        LogExameFisico logExameFisico = logExameFisicoDao.porNumProntuarioEData(logProntuario.getNumProntuario(), logProntuario.getDataEdicao());
        List<LogListaProblemas> logListaProblemases = logListaProblemasDao.porNumProntuarioEData(logProntuario.getNumProntuario(), logProntuario.getDataEdicao());
        
        for (LogListaProblemas logListaProblemase : logListaProblemases) {
            if(logListaProblemase != null)
            this.logListaProblemasDao.deletar(logListaProblemase);
        }
        if(logExameFisico != null)
        this.logExameFisicoDao.deletar(logExameFisico);
        if(logEstiloDeVida != null)
        this.logEstiloDeVidaDao.deletar(logEstiloDeVida);
        if(logAnamnese != null)
        this.logAnamneseDao.deletar(logAnamnese);
        if(logProntuario != null)
        this.logProntuarioDao.deletar(logProntuario);
        
    }
    
}
