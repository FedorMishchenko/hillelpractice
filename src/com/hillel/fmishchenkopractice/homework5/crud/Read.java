package com.hillel.fmishchenkopractice.homework5.crud;

import org.jetbrains.annotations.NotNull;

class Read {
    Read(@NotNull ProcessorManager processor) {
        try {
            processor.read();
        }finally {
            new Menu().displayMenu();
        }
    }
}
