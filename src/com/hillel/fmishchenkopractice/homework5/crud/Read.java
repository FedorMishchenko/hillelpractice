package com.hillel.fmishchenkopractice.homework5.crud;

import org.jetbrains.annotations.NotNull;

class Read {
    Read(@NotNull Strategy strategy) {
        try {
            strategy.read();
        }finally {
            new Menu().displayMenu();
        }
    }
}
