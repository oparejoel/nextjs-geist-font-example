## Hooks & Utilities

### useIsMobile
- **Signature**: `useIsMobile(): boolean`
- **Description**: Returns `true` when viewport width is less than 768px. Uses `matchMedia` and updates on resize.
- **SSR note**: Returns `false` until mounted on the client.
- **Import**: `import { useIsMobile } from '@/hooks/use-mobile'`
- **Example**:
```tsx
import { useIsMobile } from '@/hooks/use-mobile'

export function LayoutResponsive() {
  const isMobile = useIsMobile()
  return <div>{isMobile ? 'Mobile layout' : 'Desktop layout'}</div>
}
```

### cn
- **Signature**: `cn(...inputs: ClassValue[]): string`
- **Description**: Combines class names with `clsx` and merges Tailwind classes with `tailwind-merge`.
- **Import**: `import { cn } from '@/lib/utils'`
- **Example**:
```tsx
import { cn } from '@/lib/utils'

export function Example({ isActive }: { isActive?: boolean }) {
  return (
    <div className={cn('p-4 text-sm', isActive && 'bg-primary text-primary-foreground')}>
      Hello
    </div>
  )
}
```