/*
 * Hibernate, Relational Persistence for Idiomatic Java
 *
 * Copyright (c) 2012, Red Hat Inc. or third-party contributors as
 * indicated by the @author tags or express copyright attribution
 * statements applied by the authors.  All third-party contributions are
 * distributed under license by Red Hat Inc.
 *
 * This copyrighted material is made available to anyone wishing to use, modify,
 * copy, or redistribute it subject to the terms and conditions of the GNU
 * Lesser General Public License, as published by the Free Software Foundation.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of MERCHANTABILITY
 * or FITNESS FOR A PARTICULAR PURPOSE.  See the GNU Lesser General Public License
 * for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with this distribution; if not, write to:
 * Free Software Foundation, Inc.
 * 51 Franklin Street, Fifth Floor
 * Boston, MA  02110-1301  USA
 */
package org.hibernate.metamodel.internal.source.annotations.attribute;

import java.util.List;
import java.util.Map;
import java.util.Set;

import org.hibernate.FetchMode;
import org.hibernate.engine.FetchStyle;
import org.hibernate.engine.FetchTiming;
import org.hibernate.engine.spi.CascadeStyle;
import org.hibernate.metamodel.spi.binding.Caching;
import org.hibernate.metamodel.spi.binding.CustomSQL;
import org.hibernate.metamodel.spi.source.ExplicitHibernateTypeSource;
import org.hibernate.metamodel.spi.source.ManyToAnyPluralAttributeElementSource;
import org.hibernate.metamodel.spi.source.MetaAttributeSource;
import org.hibernate.metamodel.spi.source.OneToManyPluralAttributeElementSource;
import org.hibernate.metamodel.spi.source.PluralAttributeElementNature;
import org.hibernate.metamodel.spi.source.PluralAttributeElementSource;
import org.hibernate.metamodel.spi.source.PluralAttributeKeySource;
import org.hibernate.metamodel.spi.source.PluralAttributeNature;
import org.hibernate.metamodel.spi.source.PluralAttributeSource;
import org.hibernate.metamodel.spi.source.TableSpecificationSource;

/**
 * @author Hardy Ferentschik
 */
public class PluralAttributeSourceImpl implements PluralAttributeSource {

	PluralAssociationAttribute attribute;

	public PluralAttributeSourceImpl(PluralAssociationAttribute attribute) {
		this.attribute = attribute;
	}

	@Override
	public PluralAttributeNature getPluralAttributeNature() {
		if ( Map.class.isAssignableFrom( attribute.getAttributeType() ) ) {
			return PluralAttributeNature.MAP;
		}
		else if ( List.class.isAssignableFrom( attribute.getAttributeType() ) ) {
			return PluralAttributeNature.LIST;
		}
		else if ( Set.class.isAssignableFrom( attribute.getAttributeType() ) ) {
			return PluralAttributeNature.SET;
		}
		else {
			return PluralAttributeNature.BAG;
		}
	}

	@Override
	public PluralAttributeKeySource getKeySource() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public PluralAttributeElementSource getElementSource() {
		switch ( attribute.getAttributeNature() ) {
			case MANY_TO_MANY:
				return new ManyToManyPluralAttributeElementSourceImpl( attribute );
			case MANY_TO_ANY:
				return new ManyToAnyPluralAttributeElementSourceImpl();
			case ONE_TO_MANY:
				return new OneToManyPluralAttributeElementSourceImpl();
		}
		return null;
	}

	@Override
	public TableSpecificationSource getCollectionTableSpecificationSource() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public String getExplicitSchemaName() {
		return null;
	}

	@Override
	public String getExplicitCatalogName() {
		return null;
	}

	@Override
	public String getExplicitCollectionTableName() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public String getCollectionTableComment() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public String getCollectionTableCheck() {
		return attribute.getCheckCondition();
	}

	@Override
	public Caching getCaching() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public String getCustomPersisterClassName() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public String getWhere() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public boolean isInverse() {
		return false;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public String getCustomLoaderName() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public CustomSQL getCustomSqlInsert() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public CustomSQL getCustomSqlUpdate() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public CustomSQL getCustomSqlDelete() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public CustomSQL getCustomSqlDeleteAll() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public String getName() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public boolean isSingular() {
		return false;
	}

	@Override
	public ExplicitHibernateTypeSource getTypeInformation() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public String getPropertyAccessorName() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public boolean isIncludedInOptimisticLocking() {
		return false;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public Iterable<MetaAttributeSource> metaAttributes() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public FetchMode getFetchMode() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public FetchTiming getFetchTiming() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	@Override
	public FetchStyle getFetchStyle() {
		return null;  //To change body of implemented methods use File | Settings | File Templates.
	}

	private class OneToManyPluralAttributeElementSourceImpl implements OneToManyPluralAttributeElementSource {
		@Override
		public String getReferencedEntityName() {
			return null;  //To change body of implemented methods use File | Settings | File Templates.
		}

		@Override
		public boolean isNotFoundAnException() {
			return false;  //To change body of implemented methods use File | Settings | File Templates.
		}

		@Override
		public Iterable<CascadeStyle> getCascadeStyles() {
			return null;  //To change body of implemented methods use File | Settings | File Templates.
		}

		@Override
		public PluralAttributeElementNature getNature() {
			return null;  //To change body of implemented methods use File | Settings | File Templates.
		}
	}

	private class ManyToAnyPluralAttributeElementSourceImpl implements ManyToAnyPluralAttributeElementSource {

		@Override
		public Iterable<CascadeStyle> getCascadeStyles() {
			return null;  //To change body of implemented methods use File | Settings | File Templates.
		}

		@Override
		public PluralAttributeElementNature getNature() {
			return null;  //To change body of implemented methods use File | Settings | File Templates.
		}
	}
}


