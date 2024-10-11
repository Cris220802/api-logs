package com.upiiz.logs.logs.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

import com.upiiz.logs.logs.models.LogsModel;

@Repository
public class LogsRepository {
    // Almacenar en un listado las categorias; salvar, listar, eliminar, actualizar
    // Generar de manera unica el id para cada categoria

    // Generar de manera unica el id para cada categoria
    private List <LogsModel> logs = new ArrayList(); // Evitar el null pointer exception
    private AtomicLong id = new AtomicLong(); // Para incrementar automaticamente el id

    public LogsModel postLog(LogsModel log){
        log.setLogId(id.incrementAndGet());
        logs.add(log);
        return log;
    }

    //GET - Todas las categorias
    public List<LogsModel> getLogs(){
        return logs;
    }

    //GET - solo una categoria
    public LogsModel getById(Long id){
        // Programacion funcional
        return logs.stream().filter(logs -> logs.getLogId().equals(id)).findFirst().orElse(null);

    }

    //DELETE
    public void delete(Long id){
        logs.removeIf(logs -> logs.getLogId().equals(id));
    }

    //PUT
    public LogsModel update(LogsModel log){
        delete(log.getLogId());
        logs.add(log);
        return log;
    }

}
