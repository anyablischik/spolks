package com.bsuir.spolks.command;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.Level;

import java.util.HashMap;
import java.util.Map;

abstract class AbstractCommand implements ICommand {

    Map<String, String> availableTokens;
    private Map<String, String> tokens;

    /**
     * Logger to getCommand logs.
     */
    static final Logger LOGGER = LogManager.getLogger();

    /**
     * Default constructor.
     */
    AbstractCommand() {
        tokens = new HashMap<>();
        availableTokens = new HashMap<>();
    }

    /**
     * Verify inputted tokens.
     */
    @Override
    public final void verifyTokens()  {
        LOGGER.log(Level.DEBUG, "Tokens: " + tokens);

        if (!tokens.isEmpty()) {
            for (Map.Entry<String, String> fl : tokens.entrySet()) {
                final String key = fl.getKey();
                LOGGER.log(Level.DEBUG, key);
            }
        }
    }

    /**
     * Get all command tokens.
     *
     * @return hash map
     */
    public final Map<String, String> getTokens() {
        return this.tokens;
    }

    /**
     * Put token to command.
     *
     * @param name
     * @param value
     */
    @Override
    public final void putToken(String name, String value) {
        this.tokens.put(name, value);
    }
}
