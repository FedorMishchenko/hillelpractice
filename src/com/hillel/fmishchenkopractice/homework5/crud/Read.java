package com.hillel.fmishchenkopractice.homework5.crud;

import org.jetbrains.annotations.NotNull;

import java.util.Objects;

class Read {
    Read(@NotNull ProcessorManager processor) {
        try {
            Objects.requireNonNull(processor).read();
        }finally {
            new Menu().displayMenu();
        }
    }
}
