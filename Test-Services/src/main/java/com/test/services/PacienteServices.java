
package com.test.services;

import com.test.lib.Paciente;
import com.test.services.dao.PacienteDAO;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class PacienteServices {

    @Inject
    private PacienteDAO pacienteDAO;
    
    public void save(Paciente paciente) {
        pacienteDAO.save(paciente);
    }
    
    public List<Paciente> loadAllPacientes(){
        return pacienteDAO.loadAll();
    }

    public PacienteDAO getPacienteDAO() {
        return pacienteDAO;
    }

    public void setPacienteDAO(PacienteDAO pacienteDAO) {
        this.pacienteDAO = pacienteDAO;
    }

    public void update(Paciente paciente) {
        this.pacienteDAO.update(paciente);
    }
    
    public void delete(Integer id){
        this.pacienteDAO.delete(id);
    }
    
}
