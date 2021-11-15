package by.maiseyeu.webkassa.repository;

import by.maiseyeu.webkassa.model.Receipt;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceiptRepository extends JpaRepository<Receipt, Long> {
}
