package dayz.common.items;

import java.util.ArrayList;
import java.util.List;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Icon;
import dayz.DayZ;
import dayz.common.misc.Util;

public class ItemMod extends Item
{
    public List<String> subNames;

    public ItemMod(int itemId)
    {
        super(itemId);
        maxStackSize = 1;
        setCreativeTab(DayZ.creativeTab);
    }

    @Override
    public void registerIcons(IconRegister register)
    {
        itemIcon = register.registerIcon(Util.ID + ":" + getUnlocalizedName().substring(getUnlocalizedName().indexOf(".") + 1));
    }

    @Override
    public Icon getIcon(ItemStack stack, int pass)
    {
        return itemIcon;
    }

    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer entityPlayer, List informationList, boolean advancedItemTooltips)
    {
        if (subNames == null)
        {
            return;
        }
        for (String string : subNames)
        {
            informationList.add(string);
        }
    }

    public Item subNames(String... strings)
    {
        if (subNames == null)
        {
            subNames = new ArrayList();
        }
        for (String string : strings)
        {
            subNames.add(string);
        }
        return this;
    }
}