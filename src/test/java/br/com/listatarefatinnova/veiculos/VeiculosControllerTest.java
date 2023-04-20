package br.com.listatarefatinnova.veiculos;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

@SpringBootTest
@AutoConfigureMockMvc
public class VeiculosControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testeCadastro() throws Exception {
        String json = "{\"veiculo\": \"Corsa\", \"marca\": \"CHEVROLET\", \"ano\": 2010, \"descricao\": \"Carro usado\", \"vendido\": false}";
        mockMvc.perform(MockMvcRequestBuilders.post("/veiculos").content(json).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isCreated())
                .andExpect(MockMvcResultMatchers.jsonPath("veiculo", CoreMatchers.equalTo("Corsa")))
                .andExpect(MockMvcResultMatchers.jsonPath("marca", CoreMatchers.equalTo("CHEVROLET")));
    }

    @Test
    public void testeBuscaById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/veiculos/1"))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("veiculo", CoreMatchers.equalTo("Tracker")))
                .andExpect(MockMvcResultMatchers.jsonPath("marca", CoreMatchers.equalTo("CHEVROLET")))
                .andDo(MockMvcResultHandlers.print());
    }

    @Test
    public void testeAtualizaById() throws Exception {
        String json = "{\"veiculo\": \"Ecosport\", \"marca\": \"FORD\", \"ano\": 2018, \"descricao\": \"Carro Novo\", \"vendido\": false}";
        mockMvc.perform(MockMvcRequestBuilders.put("/veiculos/2").content(json).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("id", CoreMatchers.equalTo(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("veiculo", CoreMatchers.equalTo("Ecosport")))
                .andExpect(MockMvcResultMatchers.jsonPath("marca", CoreMatchers.equalTo("FORD")));
    }

    @Test
    public void testeAtualizaVendidoById() throws Exception {
        String json = "{\"vendido\": true}";
        mockMvc.perform(MockMvcRequestBuilders.patch("/veiculos/2").content(json).contentType(MediaType.APPLICATION_JSON))
                .andExpect(MockMvcResultMatchers.status().isOk())
                .andExpect(MockMvcResultMatchers.jsonPath("id", CoreMatchers.equalTo(2)))
                .andExpect(MockMvcResultMatchers.jsonPath("vendido", CoreMatchers.equalTo(true)));
    }

    @Test
    public void testeDeletaById() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.delete("/veiculos/3"))
                .andExpect(MockMvcResultMatchers.status().isOk());
    }
}
