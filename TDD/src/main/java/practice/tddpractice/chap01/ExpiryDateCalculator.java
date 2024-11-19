package practice.tddpractice.chap01;

import java.time.LocalDate;
import java.time.YearMonth;

public class ExpiryDateCalculator {
    public LocalDate calculateExpiryDate(PayData payData) {
        int addedMonths = payData.getPayAmount() / 10_000;
        if (payData.getFirstBillingDate() != null) {
            return expiryDateUsingFirstBillingDate(payData, addedMonths);
        } else {
            return payData.getBillingDate().plusMonths(addedMonths);
        }
    }

//    private static LocalDate expiryDateUsingFirstBillingDate(PayData payData, int addedMonths) {
//        LocalDate candidateExp = payData.getBillingDate().plusMonths(addedMonths);
//        final int dayOfFirstBilling = payData.getFirstBillingDate().getDayOfMonth();
//        if (dayOfFirstBilling != candidateExp.getDayOfMonth()) {
//            final int dayLenOfCandiMon = YearMonth.from(candidateExp).lengthOfMonth();
//            if (dayLenOfCandiMon < payData.getFirstBillingDate().getDayOfMonth()) {
//                return candidateExp.withDayOfMonth(dayLenOfCandiMon);
//            }
//            return candidateExp.withDayOfMonth(payData.getFirstBillingDate().getDayOfMonth());
//        } else {
//            return candidateExp;
//        }
//    }

    private LocalDate expiryDateUsingFirstBillingDate(PayData payData, int addedMonths) {
        LocalDate candidateExp = payData.getBillingDate().plusMonths(addedMonths);
        if (isSameDayOfMonth(payData.getFirstBillingDate(), candidateExp)) {
            final int dayLenOfCandiMon = lastDateOfMonth(candidateExp);
            final int dayOfFirstBilling = payData.getFirstBillingDate().getDayOfMonth();
            if (dayLenOfCandiMon < dayOfFirstBilling) {
                return candidateExp.withDayOfMonth(dayLenOfCandiMon);
            }
            return candidateExp.withDayOfMonth(payData.getFirstBillingDate().getDayOfMonth());
        } else {
            return candidateExp;
        }
    }

    private boolean isSameDayOfMonth(LocalDate date1, LocalDate date2) {
        return date1.getDayOfMonth() != date2.getDayOfMonth();
    }

    private int lastDateOfMonth(LocalDate date) {
        return YearMonth.from(date).lengthOfMonth();
    }
}
