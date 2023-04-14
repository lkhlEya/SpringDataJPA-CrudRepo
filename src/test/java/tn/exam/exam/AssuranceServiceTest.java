package tn.exam.exam;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.exam.exam.entity.Assurance;
import tn.exam.exam.repository.AssuranceRepository;
import tn.exam.exam.repository.BeneficiaireRepository;
import tn.exam.exam.repository.ContratRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import org.junit.jupiter.api.extension.ExtendWith;

import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.exam.exam.service.AssuranceServiceImpl;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class AssuranceServiceTest {
    @Mock
    private AssuranceRepository assuranceRepository;

    @Mock
    private BeneficiaireRepository beneficiaireRepository;

    @Mock
    private ContratRepository contratRepository;

    @InjectMocks
    private AssuranceServiceImpl assuranceService;

    @Test
    @DisplayName("Test getAllAssurances method")
    public void testGetAllAssurances() {
        // Arrange
        List<Assurance> assuranceList = new ArrayList<>();
        Assurance assurance1 = new Assurance();
        assurance1.setIdAssurance(1);
        assurance1.setMontant(1000);
        assuranceList.add(assurance1);

        Assurance assurance2 = new Assurance();
        assurance2.setIdAssurance(2);
        assurance2.setMontant(2000);
        assuranceList.add(assurance2);

        when(assuranceRepository.findAll()).thenReturn(assuranceList);

        // Act
        List<Assurance> actualList = assuranceService.getAllAssurances();

        // Assert
        Assertions.assertEquals(assuranceList.size(), actualList.size());
        Assertions.assertEquals(assuranceList.get(0).getIdAssurance(), actualList.get(0).getIdAssurance());
        Assertions.assertEquals(assuranceList.get(0).getMontant(), actualList.get(0).getMontant());
        Assertions.assertEquals(assuranceList.get(1).getIdAssurance(), actualList.get(1).getIdAssurance());
        Assertions.assertEquals(assuranceList.get(1).getMontant(), actualList.get(1).getMontant());
    }
/*
    @Test
    @DisplayName("Test getAssurance method with valid id")
    public void testGetAssuranceWithValidId() {
        // Arrange
        int id = 1;
        Assurance expectedAssurance = new Assurance();
        expectedAssurance.setId(id);
        expectedAssurance.setLabel("Assurance1");

        when(assuranceRepository.findById(id)).thenReturn(Optional.of(expectedAssurance));

        // Act
        Assurance actualAssurance = assuranceService.getAssurance(id);

        // Assert
        Assertions.assertEquals(expectedAssurance, actualAssurance);
    }

    @Test
    @DisplayName("Test getAssurance method with invalid id")
    public void testGetAssuranceWithInvalidId() {
        // Arrange
        int id = 1;

        when(assuranceRepository.findById(id)).thenReturn(Optional.empty());

        // Act
        Assurance actualAssurance = assuranceService.getAssurance(id);

        // Assert
        Assertions.assertNull(actualAssurance);
    }

    @Test
    @DisplayName("Test addAssurance method")
    public void testAddAssurance() {
        // Arrange
        Assurance expectedAssurance = new Assurance();
        expectedAssurance.setId(1);
        expectedAssurance.setLabel("Assurance1");

        when(assuranceRepository.saveAndFlush(any(Assurance.class))).thenReturn(expectedAssurance);

        // Act
        Assurance actualAssurance = assuranceService.addAssurance(expectedAssurance);

        // Assert
        Assertions.assertEquals(expectedAssurance, actualAssurance);
    }
*/
}

