public class Transaction
{
  private String organizationName;
  private double debit;
  private double credit;

  public Transaction (String organizationName, double debit, double credit)
  {
    this.organizationName = organizationName;
    this.debit = debit;
    this.credit = credit;
  }

  public String getOrganizationName() {
    return organizationName;
  }

  public double getDebit() {
    return debit;
  }

  public double getCredit() {
    return credit;
  }
}
