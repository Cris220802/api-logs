package com.upiiz.logs.logs.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.upiiz.logs.logs.models.LogsModel;
import com.upiiz.logs.logs.repository.LogsRepository;

@Service
public class LogsService {
    // Requerimos el REPO - Datos/listado - Categorias

    // Inyeccion de dependencias
    LogsRepository logsRepository;
    // Crear constructor - cuando crea la instancia le pasa el repositorio
    public LogsService (LogsRepository logsRepository) {
        this.logsRepository = logsRepository;
    }

    // GET - Todas las categorias
    public List<LogsModel> getAllLogs(){
        return logsRepository.getLogs();
    }

    // GET - Categoria por Id
    public LogsModel getLogById(Long id){
        return logsRepository.getById(id);
    }

    // POST - Crear categoria
    public LogsModel createLog(LogsModel log){
        return logsRepository.postLog(log);
    }

    // PUT - Actualizar categoria
    public LogsModel updateLog(LogsModel log){
        return logsRepository.update(log);
    }

    // DELETE - Eliminar categoria
    public void deleteLog(Long id){
        logsRepository.delete(id);;
    }
}
