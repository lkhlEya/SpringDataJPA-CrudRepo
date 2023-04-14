package tn.exam.exam;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import tn.exam.exam.entity.Assurance;
import tn.exam.exam.entity.Beneficiaire;
import tn.exam.exam.entity.Contrat;
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
    @DisplayName("Test addAssurance method")
    public void testAddAssurance() {
        // Arrange
        Assurance assurance1 = new Assurance();
        assurance1.setIdAssurance(1);
        assurance1.setMontant(1000);

        when(assuranceRepository.saveAndFlush(any(Assurance.class))).thenReturn(assurance1);

        // Act
        Assurance actualAssurance = assuranceService.addAssurance(assurance1);

        // Assert
        Assertions.assertEquals(assurance1, actualAssurance);
    }

    @Test
    @DisplayName("Test updateAssurance method with valid Assurance")
    public void testUpdateAssuranceWithValidAssurance() {
        // Arrange
        Assurance assurance1 = new Assurance();
        assurance1.setIdAssurance(1);
        assurance1.setMontant(1000);

        when(assuranceRepository.saveAndFlush(any(Assurance.class))).thenReturn(assurance1);

        // Act
        Assurance actualAssurance = assuranceService.updateAssurance(assurance1);

        // Assert
        Assertions.assertEquals(assurance1, actualAssurance);
    }

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

    @Test
    @DisplayName("Test getAssurance method with valid id")
    public void testGetAssuranceWithValidId() {
        // Arrange
        int id = 1;
        Assurance assurance1 = new Assurance();
        assurance1.setIdAssurance(1);
        assurance1.setMontant(1000);

        when(assuranceRepository.findById(id)).thenReturn(Optional.of(assurance1));

        // Act
        Assurance actualAssurance = assuranceService.getAssurance(id);

        // Assert
        Assertions.assertEquals(assurance1, actualAssurance);
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

    // JUnit test for deleteAssurance method
    @Test
    @DisplayName("Test deleteAssurance method with valid id")
    public void testDeleteAssuranceWithValidId() {
        // Arrange
        int id = 1;

        when(assuranceRepository.existsById(id)).thenReturn(false);

        // Act
        boolean result = assuranceService.deleteAssurance(id);

        // Assert
        Assertions.assertTrue(result);
    }

    /*
    @Test
    @DisplayName("Test addAssuranceIncludeContBenef method with valid inputs")
    public void testAddAssuranceIncludeContBenefWithValidInputs() {
        // Arrange
        Assurance assurance1 = new Assurance();
        assurance1.setIdAssurance(1);
        assurance1.setMontant(1000);
        Beneficiaire beneficiaire = new Beneficiaire();
        beneficiaire.setCin(12345678);
        Contrat contrat = new Contrat();
        contrat.setMatricule("ABC123");

        when(beneficiaireRepository.findBeneficiaireByCin(12345678)).thenReturn(beneficiaire);
        when(contratRepository.findContratByMatricule("ABC123")).thenReturn(contrat);
        when(assuranceRepository.saveAndFlush(any(Assurance.class))).thenReturn(assurance1);

        // Act
        Assurance actualAssurance = assuranceService.addAssuranceIncludeContBenef(assurance1, 12345678, "ABC123");

        // Assert
        Assertions.assertEquals(assurance1, actualAssurance);
    }
*/

}

