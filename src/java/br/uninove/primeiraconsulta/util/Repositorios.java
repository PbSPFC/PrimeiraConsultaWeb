package br.uninove.primeiraconsulta.util;

import br.uninove.primeiraconsulta.dao.AnamneseDao;
import br.uninove.primeiraconsulta.dao.EstiloDeVidaDao;
import br.uninove.primeiraconsulta.dao.ExameFisicoDao;
import br.uninove.primeiraconsulta.dao.ListaProblemasDao;
import br.uninove.primeiraconsulta.dao.ProntuarioDao;
import br.uninove.primeiraconsulta.dao.UsuarioDao;
import br.uninove.primeiraconsulta.dao.hibernate.AnamneseHibernate;
import br.uninove.primeiraconsulta.dao.hibernate.EstiloDeVidaHibernate;
import br.uninove.primeiraconsulta.dao.hibernate.ExameFisicoHibernate;
import br.uninove.primeiraconsulta.dao.hibernate.ListaProblemasHibernate;
import br.uninove.primeiraconsulta.dao.hibernate.ProntuarioHibernate;
import br.uninove.primeiraconsulta.dao.hibernate.UsuarioHibernate;
import br.uninove.primeiraconsulta.dao.hibernate.log.LogAnamneseHibernate;
import br.uninove.primeiraconsulta.dao.hibernate.log.LogEstiloDeVidaHibernate;
import br.uninove.primeiraconsulta.dao.hibernate.log.LogExameFisicoHibernate;
import br.uninove.primeiraconsulta.dao.hibernate.log.LogListaProblemasHibernate;
import br.uninove.primeiraconsulta.dao.hibernate.log.LogProntuarioHibernate;
import br.uninove.primeiraconsulta.dao.log.LogAnamneseDao;
import br.uninove.primeiraconsulta.dao.log.LogEstiloDeVidaDao;
import br.uninove.primeiraconsulta.dao.log.LogExameFisicoDao;
import br.uninove.primeiraconsulta.dao.log.LogListaProblemasDao;
import br.uninove.primeiraconsulta.dao.log.LogProntuarioDao;
import java.io.Serializable;

import org.hibernate.Session;


public class Repositorios implements Serializable {

	public UsuarioDao getUsuarioHibernate() {
		return new UsuarioHibernate(this.getSession());
	}
        
        public ProntuarioDao getProntuarioHibernate() {
		return new ProntuarioHibernate(this.getSession());
	}
        
        public AnamneseDao getAnamneseDao(){
            return new AnamneseHibernate(this.getSession());
        }
	
        public ExameFisicoDao getExameFisicoDao(){
            return new ExameFisicoHibernate(this.getSession());
        }
        
        public EstiloDeVidaDao getEstiloDeVidaDao(){
            return new EstiloDeVidaHibernate(this.getSession());
        }
        
        public ListaProblemasDao getListaProblemasDao(){
            return new ListaProblemasHibernate(this.getSession());
        }
        
        public LogProntuarioDao getLogProntuarioHibernate() {
		return new LogProntuarioHibernate(this.getSession());
	}
        
        public LogAnamneseDao getLogAnamneseDao(){
            return new LogAnamneseHibernate(this.getSession());
        }
	
        public LogExameFisicoDao getLogExameFisicoDao(){
            return new LogExameFisicoHibernate(this.getSession());
        }
        
        public LogEstiloDeVidaDao getLogEstiloDeVidaDao(){
            return new LogEstiloDeVidaHibernate(this.getSession());
        }
        
        public LogListaProblemasDao getLogListaProblemasDao(){
            return new LogListaProblemasHibernate(this.getSession());
        }
        
	private Session getSession() {
		return (Session) FacesUtil.getRequestAttribute("session");
	}
	
}
