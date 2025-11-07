package net.fabricmc.example;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ExampleMod implements ModInitializer {
	public static final Logger LOGGER = LoggerFactory.getLogger("click-mining-forever");

	@Override
	public void onInitialize() {
		LOGGER.info("Click Mining Forever loaded - mining delays removed!");
	}
}