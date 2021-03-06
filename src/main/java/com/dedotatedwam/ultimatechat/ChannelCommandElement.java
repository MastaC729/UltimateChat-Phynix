package com.dedotatedwam.ultimatechat;

import com.dedotatedwam.ultimatechat.config.UCConfig;
import org.spongepowered.api.command.CommandSource;
import org.spongepowered.api.command.args.ArgumentParseException;
import org.spongepowered.api.command.args.CommandArgs;
import org.spongepowered.api.command.args.CommandContext;
import org.spongepowered.api.command.args.CommandElement;
import org.spongepowered.api.text.Text;

import java.util.List;
import java.util.stream.Collectors;

public class ChannelCommandElement extends CommandElement {

	public ChannelCommandElement(Text key) {
		super(key);
	}

	@Override
	protected Object parseValue(CommandSource source, CommandArgs args)
			throws ArgumentParseException {		
		return UCConfig.getInstance().getChannel(args.next());
	}

	@Override
	public List<String> complete(CommandSource src, CommandArgs args,
			CommandContext context) {		
		return UCConfig.getInstance().getChAliases().stream().filter(key->UltimateChat.getPerms().channelPerm(src, key)).sorted().collect(Collectors.toList());
	}
	
	@Override
    public Text getUsage(CommandSource src) {
        return Text.of("<channel>");
    }
}
