package zabi.minecraft.nbttooltip.config;

import java.util.function.BiFunction;

import net.minecraft.item.Item;
import net.minecraft.item.tooltip.TooltipType;
import zabi.minecraft.nbttooltip.NBTTooltip;

public enum TriggerType {

	F3H((ctx, type) -> type.isAdvanced()),
	ALWAYS_ON((ctx, type) -> true),
	TOGGLE_ON_KEY((ctx, type) -> NBTTooltip.nbtKeyToggled),
	SHOW_ON_KEY((ctx, type) -> NBTTooltip.nbtKeyPressed);

	private BiFunction<Item.TooltipContext, TooltipType, Boolean> test;

	TriggerType(BiFunction<Item.TooltipContext, TooltipType, Boolean> check) {
		this.test = check;
	}

	public boolean shouldShowTooltip(Item.TooltipContext context, TooltipType type) {
		return this.test.apply(context, type);
	}

}
