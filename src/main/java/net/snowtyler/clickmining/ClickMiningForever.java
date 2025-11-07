package net.snowtyler.clickmining;

import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import turniplabs.halplibe.util.GameStartEntrypoint;

public class ClickMiningForever implements ModInitializer, GameStartEntrypoint {
	public static final String MOD_ID = "click-mining-forever";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		LOGGER.info("Click Mining Forever initialized.");
	}

	@Override
	public void beforeGameStart() {
		LOGGER.info("Click Mining Forever loaded - mining delays removed!");
	}

	@Override
	public void afterGameStart() {
	}
}
