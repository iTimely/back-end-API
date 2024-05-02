package staff.Api.service;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;
import staff.Api.entity.Chamada;
import staff.Api.mapper.ChamadaMapper;
import staff.Api.repository.ChamadaRepository;
import staff.Api.request.ChamadaRequest;
import staff.Api.request.PresencaMapper;

@Service
@AllArgsConstructor
public class ChamadaService {

    private final ChamadaRepository chamadaRepository;
    private final PresencaService presencaService;
    private final ChamadaMapper chamadaMapper;

    public void registrarChamada(ChamadaRequest chamadaRequest) {
        Chamada chamada = chamadaMapper.mapChamadaRequestToChamada(chamadaRequest);
        chamadaRepository.save(chamada);
        presencaService.atualizarPresencasDosAlunos(PresencaMapper.mapChamadaToPresencas(chamada));
    }

    public Chamada chamadaById(String chamadaId){
        return chamadaRepository.findById(chamadaId);
    }
}
