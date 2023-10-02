package com.example.Fooder.Service.Impl;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.example.Fooder.Models.Pfp;
import com.example.Fooder.Repositories.PfpRepository;
import com.example.Fooder.Service.PfpService;

public class PfpServiceImplTest {

    @Mock
    private PfpRepository pfpRepository;
    private PfpService pfpService;
    AutoCloseable autoCloseable;
    Pfp pfp;

    @BeforeEach
    void setUp(){
        autoCloseable = MockitoAnnotations.openMocks(this);
        pfpService = new PfpServiceImpl(pfpRepository);
        pfp = new Pfp(1, "pfp1");
    }

    @AfterEach
    void tearDown() throws Exception{
        autoCloseable.close();
    }

    
    @Test
    void testGetAllPfps() {
        mock(Pfp.class);
        mock(PfpRepository.class);

        when(pfpRepository.findAll()).thenReturn(
            new ArrayList<Pfp>(Collections.singleton(pfp))
        );
        assertThat(pfpService.getAllPfps().get(0)).isEqualTo(pfp);
    }

    @Test
    void testGetPfp() {
        mock(Pfp.class);
        mock(PfpRepository.class);

        when(pfpRepository.findById(1)).thenReturn(Optional.ofNullable(pfp));
        assertThat(pfpService.getPfp(1)).isEqualTo(pfp);
    }
}
