package com.presentation.java8.stream;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.presentation.java8.Annotations.Good;
import com.presentation.java8.Annotations.Ugly;

import static java.util.stream.Collectors.toSet;

public class NestedForEach {
    @Ugly
    class NestedForEachWithExternalCollection {
        public Set<String> retrievePromoRuleNames(List<BusinessTransaction> transactions) {
            Set<String> ruleNamesWithPromo = new HashSet<>();
            transactions.forEach(transaction -> transaction.getRules().stream()
                    .filter(BusinessRule::isPromotion)
                    .forEach(rule -> ruleNamesWithPromo.add(rule.getRuleName())));
            return ruleNamesWithPromo;
        }
    }

    @Good
    class StreamOperationsChain {
        public Set<String> retrievePromoRuleNames(List<BusinessTransaction> transactions) {
            return transactions.stream()
                    .flatMap(t -> t.getRules().stream())
                    .filter(BusinessRule::isPromotion)
                    .map(BusinessRule::getRuleName)
                    .collect(toSet());
        }
    }

    class BusinessTransaction {
        List<BusinessRule> getRules() {
            return new ArrayList<>(); //stub
        }
    }

    class BusinessRule {
        String getRuleName() {
            return ""; //stub
        }

        boolean isPromotion() {
            return false; //stub
        }
    }
}
