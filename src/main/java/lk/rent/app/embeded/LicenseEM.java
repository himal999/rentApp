package lk.rent.app.embeded;/*
author :Himal
version : 0.0.1
*/

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Embeddable;
import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Embeddable
public class LicenseEM {
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate revenueLicense;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate insuranceLicense;
    @JsonFormat(pattern = "dd/MM/yyyy")
    private LocalDate smokeCertificate;
}
