package pl.coderstrust.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;
import org.hibernate.annotations.Type;
import pl.coderstrust.model.counterparty.Counterparty;
import pl.coderstrust.model.invoiceItem.InvoiceItem;

import java.time.LocalDate;
import java.util.List;

public class InvoiceBody {

  @ApiModelProperty(required = true, example = "2017-08-27")
  @Type(type = "json")
  private LocalDate date = LocalDate.now();
  @Type(type = "json")
  private Counterparty counterparty;
  @Type(type = "json")
  private List<InvoiceItem> invoiceItems;

  public InvoiceBody() {
  }

  /**
   * Invoice body for passing information to InvoiceBook.
   *
   * @param date - date.
   * @param counterparty - counterparty.
   * @param invoiceItems - list of invoice items consisting of description, amount, vatAmount
   */

  @JsonCreator
  public InvoiceBody(@JsonProperty("date") LocalDate date,
      @JsonProperty("counterparty") Counterparty counterparty,
      @JsonProperty("invoiceItems") List<InvoiceItem> invoiceItems) {
    this.date = date;
    this.counterparty = counterparty;
    this.invoiceItems = invoiceItems;

  }

  public LocalDate getDate() {
    return date;
  }

  public Counterparty getCounterparty() {
    return counterparty;
  }

  public List<InvoiceItem> getInvoiceItems() {
    return invoiceItems;
  }
}

