package thebetweenlands.client.render.model.baked;

import java.util.Collection;
import java.util.List;

import javax.vecmath.Matrix4f;

import org.apache.commons.lang3.tuple.Pair;

import com.google.common.base.Function;
import com.google.common.base.Optional;
import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableSet;
import com.google.gson.JsonParser;

import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.BakedQuad;
import net.minecraft.client.renderer.block.model.IBakedModel;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms;
import net.minecraft.client.renderer.block.model.ItemCameraTransforms.TransformType;
import net.minecraft.client.renderer.block.model.ItemOverrideList;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.vertex.VertexFormat;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.IModel;
import net.minecraftforge.client.model.IModelCustomData;
import net.minecraftforge.client.model.IPerspectiveAwareModel;
import net.minecraftforge.common.model.IModelPart;
import net.minecraftforge.common.model.IModelState;
import net.minecraftforge.common.model.TRSRTransformation;
import thebetweenlands.util.QuadBuilder;

public class ModelRubberTapLiquid implements IModel, IModelCustomData {
	private final int height;
	private final ResourceLocation fluidTexture;

	public ModelRubberTapLiquid(ResourceLocation fluidTexture, int height) {
		this.fluidTexture = fluidTexture;
		this.height = height;
	}

	@Override
	public Collection<ResourceLocation> getDependencies() {
		return ImmutableSet.of();
	}

	@Override
	public Collection<ResourceLocation> getTextures() {
		if(this.height > 0)
			return ImmutableSet.of(this.fluidTexture);
		return ImmutableSet.of();
	}

	@Override
	public IBakedModel bake(IModelState state, VertexFormat format, Function<ResourceLocation, TextureAtlasSprite> bakedTextureGetter) {
		ImmutableMap<TransformType, TRSRTransformation> map = IPerspectiveAwareModel.MapWrapper.getTransforms(state);
		return new BakedModelRubberTapLiquid(format, state.apply(Optional.<IModelPart>absent()), map, this.fluidTexture != null ? bakedTextureGetter.apply(this.fluidTexture) : null, this.height);
	}

	@Override
	public IModelState getDefaultState() {
		return TRSRTransformation.identity();
	}

	@Override
	public ModelRubberTapLiquid process(ImmutableMap<String, String> customData) {
		if(!customData.containsKey("fluid_texture")) 
			return this;

		JsonParser parser = new JsonParser();

		String fluidJsonStr = customData.get("fluid_texture");
		String fluid = parser.parse(fluidJsonStr).getAsString();

		int height = 0;

		if(customData.containsKey("fluid_height")) {
			String fluidHeightJsonStr = customData.get("fluid_height");
			height = parser.parse(fluidHeightJsonStr).getAsInt();
		}

		return new ModelRubberTapLiquid(new ResourceLocation(fluid), height);
	}

	private static final class BakedModelRubberTapLiquid implements IBakedModel, IPerspectiveAwareModel {
		protected final TRSRTransformation transformation;
		protected final ImmutableMap<TransformType, TRSRTransformation> transforms;
		private final TextureAtlasSprite fluidSprite;
		private final List<BakedQuad> quads;

		private BakedModelRubberTapLiquid(VertexFormat format, Optional<TRSRTransformation> transformation, ImmutableMap<TransformType, TRSRTransformation> transforms, TextureAtlasSprite fluidSprite, int height) {
			this.fluidSprite = fluidSprite;
			this.transformation = transformation.isPresent() ? transformation.get() : null;
			this.transforms = transforms;

			if(height > 0) {
				QuadBuilder builder = new QuadBuilder(format).setSprite(this.fluidSprite).setTransformation(this.transformation);

				double liquidHeight = 0.1D + 0.65D / 15.0D * height;

				builder.addVertexInferUV(0.225D, liquidHeight, 0.485D);
				builder.addVertexInferUV(0.225D, liquidHeight, 1.18D);
				builder.addVertexInferUV(0.775D, liquidHeight, 1.18D);
				builder.addVertexInferUV(0.775D, liquidHeight, 0.485D);

				this.quads = builder.build();
			} else {
				this.quads = ImmutableList.of();
			}
		}

		@Override
		public List<BakedQuad> getQuads(IBlockState state, EnumFacing side, long rand) {
			return this.quads;
		}

		@Override
		public boolean isAmbientOcclusion() {
			return false;
		}

		@Override
		public boolean isGui3d() {
			return false;
		}

		@Override
		public boolean isBuiltInRenderer() {
			return false;
		}

		@Override
		public TextureAtlasSprite getParticleTexture() {
			return this.fluidSprite;
		}

		@Override
		public ItemCameraTransforms getItemCameraTransforms() {
			return ItemCameraTransforms.DEFAULT;
		}

		@Override
		public ItemOverrideList getOverrides() {
			return ItemOverrideList.NONE;
		}

		@Override
		public Pair<? extends IBakedModel, Matrix4f> handlePerspective(TransformType type) {
			return IPerspectiveAwareModel.MapWrapper.handlePerspective(this, this.transforms, type);
		}
	}
}
