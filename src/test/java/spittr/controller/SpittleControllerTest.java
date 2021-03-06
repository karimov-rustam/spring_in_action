package spittr.controller;

import org.junit.Test;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.web.servlet.view.InternalResourceView;
import spittr.data.SpittleRepository;
import spittr.model.Spittle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import static org.hamcrest.CoreMatchers.hasItems;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;

public class SpittleControllerTest {

    // Testing a request for Spittle with specified Id
    @Test
    public void testSpittle() throws Exception {
        // given
        Spittle expectedSpittle = new Spittle("Hello", new Date());
        SpittleRepository mockRepository = mock(SpittleRepository.class);
        when(mockRepository.findOne(12345L)).thenReturn(expectedSpittle);

        // when
        SpittleController controller = new SpittleController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller).build();

        // than
        mockMvc.perform(get("/spittles/12345"))
                .andExpect(view().name("spittle"))
                .andExpect(model().attributeExists("spittle"))
                .andExpect(model().attribute("spittle", expectedSpittle));


    }

    // test paged list of spittles
    @Test
    public void shouldShowPagedSpittles() throws Exception {
        List<Spittle> expectedSpittles = createSpittlesList(50);
        SpittleRepository mockRepository = mock(SpittleRepository.class);
        when(mockRepository.findSpittles(238900, 50))
                .thenReturn(expectedSpittles);

        SpittleController controller = new SpittleController(mockRepository);
        MockMvc mockMvc = standaloneSetup(controller)
                .setSingleView(new InternalResourceView("/WEB-INF/views/spittles.jsp"))
                .build();

        mockMvc.perform(get("/spittles?max=238900&count=50"))
                .andExpect(view().name("spittles"))
                .andExpect(model().attributeExists("spittleList"))
                .andExpect(model().attribute("spittleList", hasItems(expectedSpittles.toArray())));
    }

    private List<Spittle> createSpittlesList(int count) {
        List<Spittle> spittles = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            spittles.add(new Spittle("Spittle " + i, new Date()));
        }
        return spittles;
    }

    /*
        @Test
        public void shouldShowRecentSpittles() throws Exception {
            // given
            List<Spittle> expectedSpittles = createSpittlesList(20);
            SpittleRepository mockRepository = mock(SpittleRepository.class);
            when(mockRepository.findSpittles(2000, 20))
                    .thenReturn(expectedSpittles);

            // when
            SpittleController controller = new SpittleController(mockRepository);
            MockMvc mockMvc = standaloneSetup(controller)
                    .setSingleView(new InternalResourceView("/WEB-INF/views/spittles.jsp"))
                    .build();

            // than
            mockMvc.perform(get("/spittles"))
                    .andExpect(view().name("spittles"))
                    .andExpect(model().attributeExists("spittleList"))
                    .andExpect(model().attribute("spittleList",
                            hasItems(expectedSpittles.toArray())));
        }
    */

}