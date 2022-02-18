package com.halonsov.examples.exchangerate.controller.response;

import com.halonsov.examples.exchangerate.utils.ExchangeRate;

public class ExchangeRates {
    private ExchangeRate dof;
    private ExchangeRate fixer;
    private ExchangeRate banxico;

    public ExchangeRates() {
    }

    public ExchangeRates(ExchangeRate dof, ExchangeRate fixer, ExchangeRate banxico) {
        this.dof = dof;
        this.fixer = fixer;
        this.banxico = banxico;
    }

    public ExchangeRate getDof() {
        return this.dof;
    }

    public void setDof(ExchangeRate dof) {
        this.dof = dof;
    }

    public ExchangeRate getFixer() {
        return this.fixer;
    }

    public void setFixer(ExchangeRate fixer) {
        this.fixer = fixer;
    }

    public ExchangeRate getBanxico() {
        return this.banxico;
    }

    public void setBanxico(ExchangeRate banxico) {
        this.banxico = banxico;
    }

}
